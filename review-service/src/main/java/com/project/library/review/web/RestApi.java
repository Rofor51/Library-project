package com.project.library.review.web;

import com.project.library.review.entity.Review;
import com.project.library.review.entity.ReviewDto;
import com.project.library.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public List<ReviewDto> getAllReviews() {
        return reviewService.getAllReviews().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public List<ReviewDto> getReviewsByBookId(@PathVariable("id") Long id) {
        return reviewService.getReviewsByBook(id).stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody @Validated ReviewDto reviewDto) {
       reviewService.createReview(reviewDto.getBookId(),reviewDto.getUsername(),reviewDto.getComment(),reviewDto.getPoints(),reviewDto.getDate());
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ReviewDto updateReview(@RequestBody @Validated ReviewDto reviewDto) {
        return convertToDto(reviewService.updateReview(reviewDto.getId(),reviewDto.getUsername(),reviewDto.getComment(),reviewDto.getPoints(),reviewDto.getDate()));
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
