package com.project.library.catalogservice.bookcatalog.models;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
public class BookDetail extends RepresentationModel<BookDetail> {
    private Long bookId;
    private String title;
    private Integer pages;
    private Date year;
    private Boolean isAvailable;
    private Set<Author> authors;
    private List<Reviews> reviews;
    private String imageLink;

    public BookDetail(Long bookId, String title, Integer pages, Date year, Set<Author> authors, Boolean isAvailable, String imageLink) {
        this.bookId = bookId;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.isAvailable = isAvailable;
        this.imageLink = imageLink;
    }

    public BookDetail(Long bookId, String title, Integer pages, Date year, Set<Author> authors, List<Reviews> reviews, Boolean isAvailable, String imageLink) {
        this.bookId = bookId;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.reviews = reviews;
        this.isAvailable = isAvailable;
        this.imageLink = imageLink;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "BookDetail{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                ", isAvailable=" + isAvailable +
                ", authors=" + authors +
                ", reviews=" + reviews +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
