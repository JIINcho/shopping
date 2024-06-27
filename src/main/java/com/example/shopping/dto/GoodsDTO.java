package com.example.shopping.dto;

import com.example.shopping.entity.GoodsEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodsDTO {
    private Long id;
    private String goodsCategory;
    private String goodsName;
    private String goodsCost;
    private String goodsMemo;
    private String goodsState;
    private LocalDateTime goodsCreatedTime;
    private LocalDateTime goodsUpdatedTime;
    private MultipartFile goodsFile;
    private String originalFilename; // 원래의 사진 이름
    private String storeFileName; // 구분짓기 위한 임의의 사진 이름

    private int fileAttached; //파일첨부

    public static GoodsDTO toGoodsDTO(GoodsEntity goodsEntity) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goodsEntity.getId());
        goodsDTO.setGoodsCategory(goodsEntity.getGoodsCategory());
        goodsDTO.setGoodsName(goodsEntity.getGoodsName());
        goodsDTO.setGoodsCost(goodsEntity.getGoodsCost());
        goodsDTO.setGoodsState(goodsEntity.getGoodsState());
        goodsDTO.setGoodsMemo(goodsEntity.getGoodsMemo());
        goodsDTO.setGoodsCreatedTime(goodsEntity.getCreatedTime());
        goodsDTO.setGoodsUpdatedTime(goodsEntity.getUpdatedTime());
        if(goodsEntity.getFileAttached()==0) { // 파일 첨부가 없다면
            goodsDTO.setFileAttached(goodsEntity.getFileAttached());
        }
        else {
            goodsDTO.setFileAttached(goodsEntity.getFileAttached());
            // originalFilename에 첫번째거를 가져와서 담겠다
            goodsDTO.setOriginalFilename(goodsEntity.getGoodsFileEntityList().get(0).getOriginalFilename());
            goodsDTO.setStoreFileName(goodsEntity.getGoodsFileEntityList().get(0).getStoredFilename());
        }
        return goodsDTO;
    }
}
