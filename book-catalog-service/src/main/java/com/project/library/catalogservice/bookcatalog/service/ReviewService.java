package com.project.library.catalogservice.bookcatalog.service;

import com.project.library.catalogservice.bookcatalog.models.ReviewsDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public interface ReviewService {
    Set<ReviewsDto> getReviews(Long id);


    ReviewsDto createReview(ReviewsDto reviewsDto);

}
