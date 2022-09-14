package com.danuri.review.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity{

    private long memberId;
    private long productId;

    private String thumbnailImage;
    private String contents;

    private LocalDateTime deletedDate;

    @Builder
    private Review(long memberId, long productId, String thumbnailImage, String contents, LocalDateTime deletedDate){
        this.memberId = memberId;
        this.productId = productId;
        this.thumbnailImage = thumbnailImage;
        this.contents = contents;
        this.deletedDate = deletedDate;
    }

    public void updateThunmbnailImage(String thumbnailImage){ this.thumbnailImage = thumbnailImage; }
    public void updateContents(String contents){ this.contents = contents; }
    public void updateDeleteDate(String deleteDate){ this.deletedDate = deletedDate; }
}
