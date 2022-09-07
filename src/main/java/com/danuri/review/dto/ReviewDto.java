package com.danuri.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewDto {

    private long id;
    private long memberId;
    private long productId;

    private String thumbnailImage;
    private String contents;

    private String createdBy;
    private String updatedBy;

}
