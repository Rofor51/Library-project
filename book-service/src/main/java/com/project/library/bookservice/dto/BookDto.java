package com.project.library.bookservice.dto;

import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private Integer pages;
    private String year;
    private Boolean isAvailable;

    private Set<AuthorDto> authors;

    public BookDto(String title, Integer pages, String year, Set<AuthorDto> authors,Boolean isAvailable) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.isAvailable = isAvailable;
    }

    public BookDto(Long authorId, String title, Integer pages, String year, Set<AuthorDto> authors,Boolean isAvailable) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.bookId = authorId;
        this.isAvailable = isAvailable;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
