package com.project.library.review.service.imp;

import com.project.library.review.entity.Review;
import com.project.library.review.repo.ReviewRepository;
import com.project.library.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;


    @Override
    public Page<Review> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Page<Review> getReviewsByBook(Long id,Pageable pageable) {
        return Optional.of(reviewRepository.findByBookId(id,pageable)).orElseThrow(() -> new NoSuchElementException("Could not find review."));
    }

    @Override
    public Double getAverageScore(Long bookid) {
        OptionalDouble av = reviewRepository.findByBookId(bookid).stream().mapToDouble((rating) -> rating.getPoints()).average();
        return av.isPresent() ? av.getAsDouble(): null;
    }

    @Override
    public Review createReview(Long bookId, String userName, String comment, Double points, String date) {
        Review review = new Review(bookId, userName, comment, points, date);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(String reviewId, String userName, String comment, Double points, String date) {
        Optional<Review> review = reviewRepository.findById(verifyReview(reviewId).getId());
        if (review.isPresent()) {
            if (userName != null) {
                review.get().setUsername(userName);
            }
            if (comment != null) {
                review.get().setComment(comment);
            }
            if (points != null) {
                review.get().setPoints(points);
            }
            if (date != null) {
                review.get().setDate(date);
            }

        }
        return reviewRepository.save(review.get());
    }

    @Override
    public ResponseEntity<?> deleteReview(String reviewId) {
        Optional<Review> review = reviewRepository.findById(verifyReview(reviewId).getId());
        reviewRepository.delete(review.get());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Review verifyReview(String id) {
        return reviewRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Review was not found in database."));
    }
}
