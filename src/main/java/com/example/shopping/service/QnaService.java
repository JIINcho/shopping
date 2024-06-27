package com.example.shopping.service;

import com.example.shopping.dto.QnaDTO;
import com.example.shopping.entity.QnaEntity;
import com.example.shopping.repository.QnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaRepository qnaRepository;

    public void save(QnaDTO qnaDTO) {
        QnaEntity qnaEntity = QnaEntity.toQnaEntity(qnaDTO);
        qnaRepository.save(qnaEntity);
    }
}
