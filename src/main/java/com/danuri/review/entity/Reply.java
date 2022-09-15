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

    private long reviewId;

    private String contents;
    private long storeId;
    private LocalDateTime deletedDate;

    @OneToOne(mappedBy = "reply")
    private Review review;

    @Builder
    public Reply(long reviewId, String contents, long storeId, LocalDateTime deletedDate, Review review) {
        this.reviewId = reviewId;
        this.contents = contents;
        this.storeId = storeId;
        this.deletedDate = deletedDate;
        this.review = review;
    }

    public void updateContents(String contents){ this.contents = contents; }
    public void updateDeletedDate(LocalDateTime deletedDate){ this.deletedDate = deletedDate; }
}
