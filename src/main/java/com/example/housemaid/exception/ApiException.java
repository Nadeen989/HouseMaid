package com.example.housemaid.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
