package com.danuri.review.dto;

import com.danuri.review.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto {

    private Long id;
    private Long memberId;
    private Long productCode;

    private String thumbnailImage;
    private String title;
    private String contents;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Long createdBy;
    private Long updatedBy;

    @Setter
    private MemberDto memberDto;

    @Builder
    private ReviewDto(Long id, Long memberId, Long productCode, String thumbnailImage, String title, String contents, LocalDateTime createdDate, LocalDateTime updatedDate, Long createdBy, Long updatedBy) {
        this.id = id;
        this.memberId = memberId;
        this.productCode = productCode;
        this.thumbnailImage = thumbnailImage;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public static ReviewDto from(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .memberId(review.getMemberId())
                .productCode(review.getProductCode())
                .thumbnailImage(review.getThumbnailImage())
                .title(review.getTitle())
                .contents(review.getContents())
                .createdDate(review.getCreatedDate())
                .updatedDate(review.getUpdatedDate())
                .createdBy(review.getCreatedBy())
                .updatedBy(review.getUpdatedBy())
                .build();
    }
}
