package com.project.library.catalogservice.bookcatalog.models;

import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.Set;
@NoArgsConstructor
public class BookCatalog extends RepresentationModel<BookCatalog> {
    private Long bookId;
    private String title;
    private Integer pages;
    private Date year;

    private Set<AuthorDto> authorDtos;
    private Set<ReviewsDto> reviews;

    public BookCatalog(Long bookId, String title, Integer pages, Date year, Set<AuthorDto> authorDtos) {
        this.bookId = bookId;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authorDtos = authorDtos;
    }
    public BookCatalog(Long bookId, String title, Integer pages, Date year, Set<AuthorDto> authorDtos,Set<ReviewsDto> reviews) {
        this.bookId = bookId;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authorDtos = authorDtos;
        this.reviews = reviews;
    }


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Set<AuthorDto> getAuthorDtos() {
        return authorDtos;
    }

    public void setAuthorDtos(Set<AuthorDto> authorDtos) {
        this.authorDtos = authorDtos;
    }

    public Set<ReviewsDto> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewsDto> reviews) {
        this.reviews = reviews;
    }
}
