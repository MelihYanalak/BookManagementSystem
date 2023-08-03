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

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookEntity>> getAllBooks(){
        List<BookEntity> books = new ArrayList<>();
        books.add(new BookEntity(1,"first book","fist author",1997,"72727272"));
        return ResponseEntity.ok(books);
    }

    @GetMapping("books/{id}")
    public BookEntity getBookById(@PathVariable int id){
        return new BookEntity(id,"first book","fist author",1997,"72727272");
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.createBook(bookDto),HttpStatus.CREATED);
    }

    @PutMapping("books/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable("id") int id,@RequestBody BookEntity book){
        System.out.println(book.getAuthor());
        System.out.println(book.getTitle());
        book.setId(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
        System.out.println(id);
        return ResponseEntity.ok("Book deleted successfully");


    }


}
