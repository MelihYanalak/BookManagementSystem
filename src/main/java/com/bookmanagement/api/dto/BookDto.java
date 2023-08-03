package com.bookmanagement.api.dto;


import lombok.Data;

@Data
public class BookDto {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

}
