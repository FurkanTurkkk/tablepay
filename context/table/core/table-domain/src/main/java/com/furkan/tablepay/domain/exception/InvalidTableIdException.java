package com.furkan.tablepay.domain.exception;

public class InvalidTableIdException extends RuntimeException {
    public InvalidTableIdException(String message) {
        super(message);
    }
}
