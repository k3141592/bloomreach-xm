package com.example.demo.exception;

/**
 * Custom exception for not found situation.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
