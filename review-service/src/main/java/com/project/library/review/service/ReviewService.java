package com.project.library.review.service;

import com.project.library.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Page<Review> getAllReviews(Pageable pageable);

    Double getAverageScore(Long bookid);

    Page<Review> getReviewsByBook(Long id,Pageable pageable);

    Review createReview(Long bookId, String userName, String comment, Double points, String date);

    Review updateReview(String reviewId, String userName, String comment, Double points, String date);

    ResponseEntity<?> deleteReview(String reviewId);
}
