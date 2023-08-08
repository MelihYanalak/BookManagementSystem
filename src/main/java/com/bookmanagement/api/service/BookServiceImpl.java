package com.bookmanagement.api.service;


import com.bookmanagement.api.dto.BookDto;
import com.bookmanagement.api.exception.BookNotFoundException;
import com.bookmanagement.api.model.BookEntity;
import com.bookmanagement.api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    final private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookDto createBook(BookDto bookDto) {
        BookEntity book = mapToEntity(bookDto);
        BookEntity newBook = bookRepository.save(book);
        return mapToDto(newBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        if (books.isEmpty()){
            throw new BookNotFoundException("There is no record for any book");
        }
        else {
            return books.stream().map(this::mapToDto).collect(Collectors.toList());
        }
    }




    @Override
    public BookDto getBookById(int id) {
        return bookRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new BookNotFoundException("Book could not be found by specified id"));
    }

    @Override
    public BookDto updateBook(BookDto bookDto, int id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book could not be found by specified id"));

        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublicationYear(bookDto.getPublicationYear());
        bookRepository.save(book);
        return mapToDto(book);


    }


    @Override
    public String deleteBook(int id) {

        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book could not be found by specified id");
        }
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }




    private BookDto mapToDto(BookEntity bookEntity){
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setPublicationYear(bookEntity.getPublicationYear());
        bookDto.setIsbn(bookEntity.getIsbn());
        bookDto.setAuthor(bookEntity.getAuthor());
        bookDto.setTitle(bookEntity.getTitle());
        return bookDto;
    }
    private BookEntity mapToEntity(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDto.getId());
        bookEntity.setIsbn(bookDto.getIsbn());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setPublicationYear(bookDto.getPublicationYear());
        bookEntity.setAuthor(bookDto.getAuthor());
        return bookEntity;

    }


}

