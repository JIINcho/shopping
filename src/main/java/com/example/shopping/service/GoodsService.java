package com.example.shopping.service;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.entity.GoodsEntity;
import com.example.shopping.entity.GoodsFileEntity;
import com.example.shopping.entity.NoticeEntity;
import com.example.shopping.entity.ReviewEntity;
import com.example.shopping.repository.GoodsRepository;
import com.example.shopping.repository.GoodsFileRepositroy;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsFileRepositroy goodsFileRepositroy;

    @SneakyThrows
    public void save(GoodsDTO goodsDTO) throws IOException, IOException{
        if(goodsDTO.getGoodsFile().isEmpty()) { // goodsFile(첨부파일)이 없다면
            GoodsEntity goodsEntity = GoodsEntity.toSaveEntity(goodsDTO);
            goodsRepository.save(goodsEntity); // 엔티티를 저장
        }
        else { // 첨부파일이 있다면
            MultipartFile goodsFile = goodsDTO.getGoodsFile(); // DTO에 담긴 파일 가져오기
            String originalFileName = goodsFile.getOriginalFilename(); // 파일의 원본이름을 가져오기
            String storedFileName = System.currentTimeMillis() + "_" + originalFileName; // 새로운 파일의 이름을 생성 (숫자값_파일명)으로 생성
            String savePath = "C:/shop_img/" + storedFileName; // 해당 디엑토리에 등록
            goodsFile.transferTo(new File(savePath));
            GoodsEntity goodsEntity = GoodsEntity.toSaveFileEntity(goodsDTO); // DTO에 넘어온 자료 Entity에 저장
            Long saveId = goodsRepository.save(goodsEntity).getId(); // 해당되는 id값을 가져옴
            GoodsEntity goods = goodsRepository.findById(saveId).get();
            GoodsFileEntity goodsFileEntity = GoodsFileEntity.toGoodsFileEntity(goods, originalFileName, storedFileName);
            goodsFileRepositroy.save(goodsFileEntity);
        }
    }

    @Transactional
    public List<GoodsDTO> findAll() {
        List<GoodsEntity> goodsEntityList = goodsRepository.findAll();
        List<GoodsDTO> goodsDTOList = new ArrayList<>();

        for (GoodsEntity goodsEntity: goodsEntityList) {
            goodsDTOList.add(GoodsDTO.toGoodsDTO(goodsEntity));
        }
        return goodsDTOList;
    }

    public GoodsDTO findById(Long id) {
        Optional<GoodsEntity> optionalGoodsEntity = goodsRepository.findById(id);
        if(optionalGoodsEntity.isPresent()) {
            GoodsEntity goodsEntity = optionalGoodsEntity.get();
            GoodsDTO goodsDTO = GoodsDTO.toGoodsDTO(goodsEntity);
            return goodsDTO;
        }
        else {
            return null;
        }
    }


    public void deleteGoods(Long id) {
        goodsRepository.deleteById(id);
    }
}
