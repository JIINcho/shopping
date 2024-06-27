package com.example.shopping.dto;

import com.example.shopping.entity.QnaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QnaDTO {
    private Long id;
    private String qnaTitle;
    private String qnaName;
    private String qnaMemo;
    private int goodsId;
    private String goodsName;
    private String goodsCost;
    private int qnaHit;
    private LocalDateTime qnaCreatedTime;
    private LocalDateTime qnaUpdatedTime;

    public static QnaDTO toQnaDTO(QnaEntity qnaEntity) {
        QnaDTO qnaDTO = new QnaDTO();
        qnaDTO.setId(qnaEntity.getId());
        qnaDTO.setQnaName(qnaEntity.getQnaName());
        qnaDTO.setQnaTitle(qnaEntity.getQnaTitle());
        qnaDTO.setQnaMemo(qnaEntity.getQnaMemo());
        qnaDTO.setGoodsId(qnaEntity.getGoodsId());
        qnaDTO.setGoodsName(qnaEntity.getGoodsName());
        qnaDTO.setGoodsCost(qnaEntity.getGoodsCost());
        qnaDTO.setQnaHit(qnaEntity.getQnaHit());
        return qnaDTO;
    }
}
