package com.amit.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingHeaderInfoException extends RuntimeException{
    public static final long serialversionUID = 1L;

    public MissingHeaderInfoException(String message) {
        super(message);
    }
}
