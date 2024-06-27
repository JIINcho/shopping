package com.example.shopping.service;

import com.example.shopping.dto.GoodsDTO;
import com.example.shopping.dto.ReviewDTO;
import com.example.shopping.entity.GoodsEntity;
import com.example.shopping.entity.ReviewEntity;
import com.example.shopping.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    @Autowired
    private final ReviewRepository reviewRepository;

    private final GoodsService goodsService;

    public void save(ReviewDTO reviewDTO) {
        ReviewEntity reviewEntity = ReviewEntity.toReviewEntity(reviewDTO);
        reviewRepository.save(reviewEntity);
    }

    public List<ReviewDTO> findAll() {
        List<ReviewEntity> reviewEntityList = reviewRepository.findAll();
        List<ReviewDTO> reviewDTOList = new ArrayList<>();

        for(ReviewEntity reviewEntity: reviewEntityList) {
            reviewDTOList.add(ReviewDTO.toReviewDTO(reviewEntity));
        }
        return reviewDTOList;
    }


    public ReviewDTO findById(Long id) {
        Optional<ReviewEntity> optionalReviewEntity = reviewRepository.findById(id);
        if(optionalReviewEntity.isPresent()) {
            ReviewEntity reviewEntity = optionalReviewEntity.get();
            ReviewDTO reviewDTO = ReviewDTO.toReviewDTO(reviewEntity);
            return reviewDTO;
        }
        else {
            return null;
        }
    }

}