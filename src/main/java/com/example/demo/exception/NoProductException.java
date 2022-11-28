package com.example.demo.exception;

public class NoProductException extends RuntimeException{

    public NoProductException(String message) {
        super(String.format("%s", message) );
    }
}
