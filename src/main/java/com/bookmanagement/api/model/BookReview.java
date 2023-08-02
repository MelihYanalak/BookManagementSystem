package com.bookmanagement.api.model;

import lombok.Data;

@Data
public class BookReview {
    private int id;
    private String title;
    private String content;
    private int star;
}
