package com.danuri.review.service;

import com.danuri.review.dto.ReviewDto;
import com.danuri.review.entity.Review;
import com.danuri.review.exception.ReviewDuplicationException;
import com.danuri.review.exception.ReviewNotFoundException;
import com.danuri.review.repository.ReviewRepo;
import com.danuri.review.util.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    private final S3Upload s3Upload;

    public Long save(ReviewDto reviewDto, MultipartFile multipartFile) {

        if (reviewRepo.findReviewByMemberIdAndProductId
                (reviewDto.getMemberId(), reviewDto.getProductId()).isPresent()) {
            throw new ReviewDuplicationException("이미 리뷰를 작성했습니다.");
        }

        return reviewRepo.save(
                Review.builder()
                        .memberId(reviewDto.getMemberId())
                        .productId(reviewDto.getProductId())
                        .thumbnailImage(uploadImage(multipartFile))
                        .contents(reviewDto.getContents())
                        .build()).getId();
    }

    public ReviewDto readReview(Long id) {
        Review review = reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFoundException("존재하지 않는 리뷰입니다."));
        return ReviewDto.from(review);
    }

    public List<ReviewDto> readReviewList() {
        List<Review> reviewList = reviewRepo.findByCreatedDateIsNotNull().orElseThrow(() -> new ReviewNotFoundException("리뷰 데이터가 존재하지 않습니다."));
        return reviewList.stream().map(
                        ReviewDto::from
                )
                .collect(Collectors.toList());
    }
    @Transactional
    public void updateReview(Long id, ReviewDto reviewDto, MultipartFile multipartFile) {
        Review review = getReview(id);

        review.updateThunmbnailImage(uploadImage(multipartFile));
        review.updateContents(reviewDto.getContents());
    }

    @Transactional
    public void deleteReview(Long id) {
        Review review = getReview(id);
        review.updateDeletedDate(LocalDateTime.now());
    }

    private Review getReview(Long id){
        return reviewRepo.findById(id).orElseThrow(() -> new ReviewNotFoundException("존재하지 않는 리뷰입니다."));
    }

    private String uploadImage(MultipartFile multipartFile){
        try {
            return s3Upload.upload(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
