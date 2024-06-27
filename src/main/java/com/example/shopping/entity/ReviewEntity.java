package com.example.shopping.entity;

import com.example.shopping.dto.ReviewDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String reviewName;

    @Column
    private String reviewMemo;

    @Column
    private int goodsId;
    @Column
    private String goodsName;
    @Column
    private String goodsCost;

    public static ReviewEntity toReviewEntity(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewName(reviewDTO.getReviewName());
        reviewEntity.setReviewMemo(reviewDTO.getReviewMemo());
        reviewEntity.setGoodsId(reviewDTO.getGoodsId());
        reviewEntity.setGoodsName(reviewDTO.getGoodsName());
        reviewEntity.setGoodsCost(reviewDTO.getGoodsCost());
        return reviewEntity;
    }

}
