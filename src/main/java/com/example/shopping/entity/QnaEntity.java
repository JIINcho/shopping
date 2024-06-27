package com.example.shopping.entity;

import com.example.shopping.dto.QnaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "qna")
public class QnaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String qnaTitle;
    @Column
    private String qnaName;
    @Column
    private String qnaMemo;
    @Column
    private int goodsId;
    @Column
    private String goodsName;
    @Column
    private String goodsCost;
    @Column
    private int qnaHit;
    @Column
    private LocalDateTime qnaCreatedTime;
    @Column
    private LocalDateTime qnaUpdatedTime;

    public static QnaEntity toQnaEntity(QnaDTO qnaDTO) {
        QnaEntity qnaEntity = new QnaEntity();
        qnaEntity.setId(qnaDTO.getId());
        qnaEntity.setQnaName(qnaDTO.getQnaName());
        qnaEntity.setQnaTitle(qnaDTO.getQnaTitle());
        qnaEntity.setQnaMemo(qnaDTO.getQnaMemo());
        qnaEntity.setGoodsId(qnaDTO.getGoodsId());
        qnaEntity.setGoodsName(qnaDTO.getGoodsName());
        qnaEntity.setGoodsCost(qnaDTO.getGoodsCost());
        qnaEntity.setQnaHit(qnaDTO.getQnaHit());
        return qnaEntity;
    }
}
