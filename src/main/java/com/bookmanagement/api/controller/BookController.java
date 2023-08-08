package com.bookmanagement.api.controller;


import com.bookmanagement.api.dto.BookDto;
import com.bookmanagement.api.model.BookEntity;
import com.bookmanagement.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

    final private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);

    }

    @GetMapping("books/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.createBook(bookDto),HttpStatus.CREATED);
    }

    @PutMapping("books/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") int id,@RequestBody BookDto bookDto){
        BookDto updatedBook = bookService.updateBook(bookDto,id);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
        String response = bookService.deleteBook(id);
        return new ResponseEntity<>(response,HttpStatus.OK);


    }


}
