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
    private Boolean available;

    public BookDto(String title, Integer pages, Date year,Boolean available, Set<AuthorDto> authors) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.available = available;
    }

    public BookDto(Long bookId, String title, Integer pages, Date year,Boolean available, Set<AuthorDto> authors) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.bookId = bookId;
        this.available = available;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
