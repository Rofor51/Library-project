package com.project.library.bookservice.dto;

import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private Integer pages;
    private Date year;
    private Set<AuthorDto> authors;


    private String imageLink;

    private Boolean inStore;

    public BookDto(String title, Integer pages, Date year, Set<AuthorDto> authors, String imageLink, Boolean inStore) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.imageLink = imageLink;
        this.inStore = inStore;

    }

    public BookDto(Long bookId, String title, Integer pages, Date year, Set<AuthorDto> authors, String imageLink, Boolean inStore) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.bookId = bookId;
        this.imageLink = imageLink;
        this.inStore = inStore;

    }

    public Boolean getInStore() {
        return inStore;
    }

    public void setInStore(Boolean inStore) {
        this.inStore = inStore;
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

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
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


}
