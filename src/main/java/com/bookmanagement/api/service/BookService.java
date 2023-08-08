package com.bookmanagement.api.service;

import com.bookmanagement.api.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<BookDto> getAllBooks();
    BookDto getBookById(int id);
    BookDto updateBook(BookDto bookDto, int id);
    String deleteBook(int id);

}
