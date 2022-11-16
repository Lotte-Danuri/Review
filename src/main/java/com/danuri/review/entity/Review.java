package com.danuri.review.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity{

    private Long memberId;
    private Long productCode;

    private String thumbnailImage;
    private String contents;

    @OneToOne
    @JoinColumn(name = "id")
    private Reply reply;

    @Builder
    private Review(Long memberId, Long productCode, String thumbnailImage, String contents, LocalDateTime deletedDate){
        this.memberId = memberId;
        this.productCode = productCode;
        this.thumbnailImage = thumbnailImage;
        this.contents = contents;
    }

    public void updateThunmbnailImage(String thumbnailImage){ this.thumbnailImage = thumbnailImage; }
    public void updateContents(String contents){ this.contents = contents; }
}
