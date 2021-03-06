package com.project.library.catalogservice.bookcatalog.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Reviews {

    private String id;
    private Long bookId;
    private String username;
    private String comment;
    private Double points;
    private String date;

    public Reviews(String id, Long bookId, String username, String comment, Double points, String date) {
        this.id = id;
        this.bookId = bookId;
        this.username = username;
        this.comment = comment;
        this.points = points;
        this.date = date;
    }

    public Reviews(Long bookId, String username, String comment, Double points, String date) {
        this.bookId = bookId;
        this.username = username;
        this.comment = comment;
        this.points = points;
        this.date = date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
