package com.example.shopping.dto;

import com.example.shopping.entity.ReviewEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDTO {
    private Long id;
    private String reviewName;
    private String reviewMemo;
    private int goodsId;
    private String goodsName;
    private String goodsCost;

    public static ReviewDTO toReviewDTO(ReviewEntity reviewEntity) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(reviewEntity.getId());
        reviewDTO.setReviewName(reviewEntity.getReviewName());
        reviewDTO.setReviewMemo(reviewEntity.getReviewMemo());
        reviewDTO.setGoodsId(reviewEntity.getGoodsId());
        reviewDTO.setGoodsName(reviewEntity.getGoodsName());
        reviewDTO.setGoodsCost(reviewEntity.getGoodsCost());
        return reviewDTO;
    }

}
