package com.bookmanagement.api.model;


import lombok.Data;

@Data
public class BookEntity {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;


}
