package com.bookmanagement.api.service;

import com.bookmanagement.api.dto.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);
}
