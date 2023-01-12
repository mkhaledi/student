package com.amit.student.controller;

import com.amit.student.exception.MissingHeaderInfoException;
import com.amit.student.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Map<String, Object>> handleUserNotFoundException
            (RecordNotFoundException ex, WebRequest request)
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

   /* @ExceptionHandler(MissingHeaderInfoException.class)
    public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException
            (MissingHeaderInfoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/
}
