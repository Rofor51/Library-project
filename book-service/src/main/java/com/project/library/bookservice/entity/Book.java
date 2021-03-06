package com.project.library.bookservice.entity;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "date")
    private Date year;
    @Column(name = "imagelink")
    private String imageLink;
    @Column(name = "instore")
    private Boolean inStore;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "author_id", nullable = false))
    private Set<Author> authors = new HashSet<>();


    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Book(String title, Integer pages, Date year, String imageLink, Boolean inStore, Set<Author> authors) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.imageLink = imageLink;
        this.inStore = inStore;
    }
    public Book(Long id, String title, Integer pages, Date year, String imageLink, Boolean inStore, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.authors = authors;
        this.imageLink = imageLink;
        this.inStore = inStore;
    }


    public Boolean getInStore() {
        return inStore;
    }

    public void setInStore(Boolean test) {
        this.inStore = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
