package com.danuri.review.repository;

import com.danuri.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
    Optional<Review> findReviewByMemberIdAndProductCode(Long memberId, Long productCode);

    Optional<List<Review>> findByCreatedDateIsNotNull();

    Optional<List<Review>> findByProductCode(Long id);
}
