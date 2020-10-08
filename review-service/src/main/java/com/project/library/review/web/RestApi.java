package com.project.library.review.web;

import com.project.library.review.entity.Review;
import com.project.library.review.entity.ReviewDto;
import com.project.library.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/reviews")
@RequiredArgsConstructor
public class RestApi {
    private final ModelMapper modelMapper;
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getAllReviews(Pageable pageable) {
        Page<Review> reviews = reviewService.getAllReviews(pageable);
        List<ReviewDto> reviewDtos = reviews.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
        return reviewDtos;
    }

    @GetMapping("/{id}")
    public List<ReviewDto> getReviewsByBookId(@PathVariable("id") Long id,Pageable pageable) {
        Page<Review> reviews = reviewService.getReviewsByBook(id,pageable);
        List<ReviewDto> reviewDtos = reviews.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
        return reviewDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody @Validated ReviewDto reviewDto) {
        reviewService.createReview(reviewDto.getBookId(), reviewDto.getUsername(), reviewDto.getComment(), reviewDto.getPoints(), reviewDto.getDate());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@RequestBody @Validated ReviewDto reviewDto) {
         convertToDto(reviewService.updateReview(reviewDto.getId(), reviewDto.getUsername(), reviewDto.getComment(), reviewDto.getPoints(), reviewDto.getDate()));
    }

    @GetMapping("average/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Double getAverageScoreForBook(@PathVariable("id") Long bookId) {
       return reviewService.getAverageScore(bookId);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    private String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }

    private ReviewDto convertToDto(Review review) {
        ReviewDto bookDto = modelMapper.map(review, ReviewDto.class);
        return bookDto;
    }
}
