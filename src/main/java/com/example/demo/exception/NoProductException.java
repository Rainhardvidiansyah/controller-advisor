package com.example.demo.exception;

public class NoProductException extends RuntimeException{
    final static String MESSAGE_OF_PRODUCT_NOT_FOUND = "Product Not Found";
    public NoProductException() {
        super(MESSAGE_OF_PRODUCT_NOT_FOUND);
    }
}
