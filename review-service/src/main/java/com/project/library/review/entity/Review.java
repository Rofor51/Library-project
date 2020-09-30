package com.project.library.review.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "user_reviews")
@NoArgsConstructor
public class Review {
    @Id
    private String id;
    private Long bookId;
    private String username;
    private String comment;
    private Double points;
    private String date;

    public Review(Long bookId, String username, String comment, Double points, String date) {
        this.bookId = bookId;
        this.username = username;
        this.comment = comment;
        this.points = points;
        this.date = date;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", bookId=" + bookId +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", points=" + points +
                ", date=" + date +
                '}';
    }
}
