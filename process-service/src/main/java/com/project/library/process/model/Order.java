package com.project.library.process.model;

import java.util.Arrays;

public class Order  {
    private String userName;
    private Long [] bookId;

    public Order() {
    }

    public Order(String userName, Long[] bookId) {
        this.userName = userName;
        this.bookId = bookId;
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
        return "Order{" +
                "userName='" + userName + '\'' +
                ", bookId=" + Arrays.toString(bookId) +
                '}';
    }
}
