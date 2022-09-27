package com.danuri.review.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Reply extends BaseEntity{

    private Long reviewId;

    private String contents;
    private Long storeId;

    @OneToOne(mappedBy = "reply")
    private Review review;

    @Builder
    public Reply(Long reviewId, String contents, Long storeId, LocalDateTime deletedDate, Review review) {
        this.reviewId = reviewId;
        this.contents = contents;
        this.storeId = storeId;
        this.review = review;
    }

    public void updateContents(String contents){ this.contents = contents; }

}
