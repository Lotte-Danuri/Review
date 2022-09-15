package com.danuri.review.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReplyDto {

    private long reviewId;

    private String contents;
    private long storeId;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private String createdBy;
    private String updatedBy;

    @Builder
    public ReplyDto(long reviewId, String contents, long storeId, LocalDateTime createdDate, LocalDateTime updatedDate, String createdBy, String updatedBy) {
        this.reviewId = reviewId;
        this.contents = contents;
        this.storeId = storeId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
