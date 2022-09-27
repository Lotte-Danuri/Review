package com.danuri.review.dto;

import com.danuri.review.entity.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReplyDto {

    private Long reviewId;

    private String contents;
    private Long storeId;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private Long createdBy;
    private Long updatedBy;

    @Builder
    public ReplyDto(Long reviewId, String contents, Long storeId, LocalDateTime createdDate, LocalDateTime updatedDate, Long createdBy, Long updatedBy) {
        this.reviewId = reviewId;
        this.contents = contents;
        this.storeId = storeId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public ReplyDto(Reply reply) {
        this.reviewId = reply.getReviewId();
        this.contents = reply.getContents();
        this.storeId = reply.getStoreId();
        this.createdDate = reply.getCreatedDate();
        this.updatedDate = reply.getUpdatedDate();
        this.createdBy = reply.getCreatedBy();
        this.updatedBy = reply.getUpdatedBy();
    }
}
