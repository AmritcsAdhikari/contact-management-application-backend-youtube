package com.mycompany.contactapi.advice;

import com.mycompany.contactapi.exception.ContactNotFoundException;
import com.mycompany.contactapi.exception.GroupNotFoundException;
import com.mycompany.contactapi.model.MyError;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        HashMap<String,String> errorHM= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorHM.put(fieldName,errorMessage);
        });

        return ResponseEntity.badRequest().body(errorHM);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<MyError> handleDuplicateKeyException(DuplicateKeyException ex) {

        MyError err = MyError.builder()
                        .date(String.valueOf(LocalDateTime.now()))
                                .code(700)
                                        .message("Duplicate Insertion! " + ex.getMessage())
                                                .status(String.valueOf(HttpStatus.CONFLICT)).build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<MyError> handleContactNotFoundException(ContactNotFoundException ex) {

        MyError err = MyError.builder()
                        .date(String.valueOf(LocalDateTime.now()))
                                .code(500)
                                        .message(ex.getMessage())
                                                .status(String.valueOf(HttpStatus.CONFLICT)).build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<MyError> handleGroupNotFoundException(GroupNotFoundException ex) {

        MyError err = MyError.builder()
                .date(String.valueOf(LocalDateTime.now()))
                .code(500)
                .message(ex.getMessage())
                .status(String.valueOf(HttpStatus.CONFLICT)).build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
}
