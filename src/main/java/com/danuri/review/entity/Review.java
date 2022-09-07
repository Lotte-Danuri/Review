package com.danuri.review.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity{

    private long memberId;
    private long productId;

    private String thumbnailImage;
    private String contents;

    @Builder
    private Review(long memberId, long productId, String thumbnailImage, String contents){
        this.memberId = memberId;
        this.productId = productId;
        this.thumbnailImage = thumbnailImage;
        this.contents = contents;
    }
}
