package com.project.library.review.service;

import com.project.library.review.entity.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();

    List<Review> getReviewsByBook(Long id);

    Review createReview(Long bookId, String userName, String comment, Double points, String date);

    Review updateReview(String reviewId, String userName, String comment, Double points, String date);

    ResponseEntity<?> deleteReview(String reviewId);
}
