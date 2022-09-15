package com.danuri.review.service;

import com.danuri.review.dto.ReviewDto;
import com.danuri.review.entity.Review;
import com.danuri.review.exception.ReviewDuplicationException;
import com.danuri.review.exception.ReviewNotFoundException;
import com.danuri.review.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    public long save(ReviewDto reviewDto) {

        if (reviewRepo.findReviewByMemberIdAndProductId
                (reviewDto.getMemberId(), reviewDto.getProductId()).isPresent()) {
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

    public ReviewDto readReview(Long id) {
        Review review = reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFoundException("존재하지 않는 리뷰입니다."));
        return new ReviewDto(review);
    }

    public List<ReviewDto> readReviewList() {
        List<Review> reviewList = reviewRepo.findByCreatedDateIsNotNull().orElseThrow(() -> new ReviewNotFoundException("리뷰 데이터가 존재하지 않습니다."));
        return reviewList.stream().map(
                        review -> new ReviewDto(review)
                )
                .collect(Collectors.toList());
    }

    public void updateReview(Long id, ReviewDto reviewDto) {
        Review review = getReview(id);

        //TODO thumbnailImage 수정
        review.updateThunmbnailImage(reviewDto.getThumbnailImage());
        review.updateContents(reviewDto.getContents());

        reviewRepo.save(review);
    }

    public void deleteReview(Long id) {
        Review review = getReview(id);
        review.updateDeletedDate(LocalDateTime.now());
        reviewRepo.save(review);
    }

    private Review getReview(Long id){
        return reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFoundException("존재하지 않는 리뷰입니다."));
    }

}
