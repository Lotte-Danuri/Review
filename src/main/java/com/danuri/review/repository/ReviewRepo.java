package com.danuri.review.repository;

import com.danuri.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
    Optional<Review> findReviewByMemberIdAndProductId(Long memberId, Long productId);

    Optional<List<Review>> findByCreatedDateIsNotNull();

    Optional<List<Review>> findByProductId(Long id);
}
