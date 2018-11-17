package com.tutorial.springboot.ui.exceptions;

public class UserServiceException extends RuntimeException {

    public UserServiceException(String message) {
        super(message);
    }

}
