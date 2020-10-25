package com.project.library.catalogservice.bookcatalog.models;

import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
public class BookCatalog extends RepresentationModel<BookCatalog> {
    private Long bookId;
    private String title;
    private Double averageScore;
    private String imageLink;


    public BookCatalog(Long bookId,String title, Double averageScore, String imageLink) {
        this.bookId = bookId;
        this.title = title;
        this.averageScore = averageScore;
        this.imageLink = imageLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
