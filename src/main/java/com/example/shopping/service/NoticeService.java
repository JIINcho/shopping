package com.example.shopping.service;

import com.example.shopping.dto.NoticeDTO;
import com.example.shopping.entity.NoticeEntity;
import com.example.shopping.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    public void save(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = NoticeEntity.toSaveEntity(noticeDTO);
        noticeRepository.save(noticeEntity);
    }

    public List<NoticeDTO> findAll() {
        List<NoticeEntity> noticeEntityList = noticeRepository.findAllDesc();
        List<NoticeDTO> noticeDTOList = new ArrayList<>();

        for (NoticeEntity noticeEntity: noticeEntityList) {
            noticeDTOList.add(NoticeDTO.toNoticeDTO(noticeEntity));
        }
        return noticeDTOList;
    }

    public NoticeDTO findById(Long id) {
        Optional<NoticeEntity> optionalNoticeEntity = noticeRepository.findById(id);
        if(optionalNoticeEntity.isPresent()) { // isPresent() -> 값이 있다
            NoticeEntity noticeEntity = optionalNoticeEntity.get();
            NoticeDTO noticeDTO = NoticeDTO.toNoticeDTO(noticeEntity);
            return noticeDTO;
        }
        else {
            return null;
        }
    }

    @Transactional
    public void updateHits(Long id) {
        noticeRepository.updateHit(id); // updateHit값을 해당 id에 업데이트
    }

}
