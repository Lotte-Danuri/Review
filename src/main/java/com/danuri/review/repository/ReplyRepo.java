package com.danuri.review.repository;

import com.danuri.review.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReplyRepo extends JpaRepository<Reply, Long> {
    Optional<Reply> findByReviewId(Long reviewId);
}
