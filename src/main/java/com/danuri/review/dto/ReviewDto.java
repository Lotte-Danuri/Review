package com.danuri.review.dto;

import com.danuri.review.entity.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto {

    private Long id;
    private Long memberId;
    private Long productId;

    private String thumbnailImage;
    private String contents;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Long createdBy;
    private Long updatedBy;

    @Builder
    private ReviewDto(Long id, Long memberId, Long productId, String thumbnailImage, String contents, LocalDateTime createdDate, LocalDateTime updatedDate, Long createdBy, Long updatedBy) {
        this.id = id;
        this.memberId = memberId;
        this.productId = productId;
        this.thumbnailImage = thumbnailImage;
        this.contents = contents;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public static ReviewDto from(Review review){
        return ReviewDto.builder()
                .id(review.getId())
                .memberId(review.getMemberId())
                .productId(review.getProductId())
                .thumbnailImage(review.getThumbnailImage())
                .contents(review.getContents())
                .createdDate(review.getCreatedDate())
                .updatedDate(review.getUpdatedDate())
                .createdBy(review.getCreatedBy())
                .updatedBy(review.getUpdatedBy())
                .build();
    }
}
