package com.ti.blog.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id, String message) {
        super("The " + message + " id '" + id + "' does not exist in our records");

    }

}