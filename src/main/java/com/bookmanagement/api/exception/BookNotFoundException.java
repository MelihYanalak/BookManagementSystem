package com.bookmanagement.api.exception;

public class BookNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1;

    public BookNotFoundException(String message){
        super(message);


    }



}
