package com.project.library.process.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection = "user_order")
public class UserOrder {
    @Id
    private String id;
    private String userName;
    private Long [] bookId;

    public UserOrder() {
    }

    public UserOrder(String userName, Long[] bookId) {
        this.userName = userName;
        this.bookId = bookId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long[] getBookId() {
        return bookId;
    }

    public void setBookId(Long[] bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", bookId=" + Arrays.toString(bookId) +
                '}';
    }
}
