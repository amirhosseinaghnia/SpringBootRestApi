package com.tutorial.springboot.ui.exceptions;

import com.tutorial.springboot.ui.model.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errMessage = ex.getLocalizedMessage();

        if (errMessage == null) errMessage = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(errMessage, new Date());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

        String errMessage = ex.getLocalizedMessage();

        if (errMessage == null) errMessage = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(errMessage, new Date());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {

        String errMessage = ex.getLocalizedMessage();

        if (errMessage == null) errMessage = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(errMessage, new Date());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
