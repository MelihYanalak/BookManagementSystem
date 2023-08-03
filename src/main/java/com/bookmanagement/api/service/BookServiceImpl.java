package com.bookmanagement.api.service;


import com.bookmanagement.api.dto.BookDto;
import com.bookmanagement.api.model.BookEntity;
import com.bookmanagement.api.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookDto createBook(BookDto bookDto) {
        BookEntity book = new BookEntity();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setIsbn(bookDto.getIsbn());
        BookEntity newBook = bookRepository.save(book);
        BookDto bookResponse = new BookDto();
        bookResponse.setAuthor(newBook.getAuthor());
        bookResponse.setIsbn(newBook.getIsbn());
        bookResponse.setTitle(newBook.getTitle());
        bookResponse.setPublicationYear(newBook.getPublicationYear());
        return bookResponse;
    }
}

