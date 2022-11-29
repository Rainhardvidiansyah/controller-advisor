package com.example.demo.exception;

public class ProductCannotBeSaveException extends RuntimeException{


    public ProductCannotBeSaveException(String message) {
        super(String.format("%s", message));
    }
}
