package com.danuri.review.dto;

import com.danuri.review.entity.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto {

    private long id;
    private long memberId;
    private long productId;

    private String thumbnailImage;
    private String contents;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private String createdBy;
    private String updatedBy;

    public ReviewDto(Review review){
        this.id = review.getId();
        this.memberId = review.getMemberId();
        this.productId = review.getProductId();
        this.thumbnailImage = review.getThumbnailImage();
        this.contents = review.getContents();
        this.createdDate = review.getCreatedDate();
        this.updatedDate = review.getUpdatedDate();
    }

    @Builder
    public ReviewDto(long id, long memberId, long productId, String thumbnailImage, String contents, LocalDateTime createdDate, LocalDateTime updatedDate, String createdBy, String updatedBy) {
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
}
