package com.danuri.review.service;

import com.danuri.review.dto.ReviewDto;
import com.danuri.review.entity.Review;
import com.danuri.review.exception.ReviewDuplicationException;
import com.danuri.review.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    public long save(ReviewDto reviewDto){

        if(reviewRepo.findReviewByMemberIdAndProductId
                (reviewDto.getMemberId(), reviewDto.getProductId()).isPresent()){
            throw new ReviewDuplicationException("이미 리뷰를 작성했습니다.");
        }

        //TODO thumbnailImage 수정
        return reviewRepo.save(
                Review.builder()
                        .memberId(reviewDto.getMemberId())
                        .productId(reviewDto.getProductId())
                        .thumbnailImage("")
                        .contents(reviewDto.getContents())
                .build()).getId();
    }

}
