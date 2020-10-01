package com.project.library.catalogservice.bookcatalog.service.imp;

import com.project.library.catalogservice.bookcatalog.feignclient.ReviewClient;
import com.project.library.catalogservice.bookcatalog.models.ReviewsDto;
import com.project.library.catalogservice.bookcatalog.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewClient reviewClient;

    @Override
    public Set<ReviewsDto> getReviews(Long id) {
        return reviewClient.getReviews(id);
    }

    @Override
    public ReviewsDto createReview(ReviewsDto reviewsDto) {
        return reviewClient.createReview(reviewsDto);
    }
}
