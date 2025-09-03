package me.dio.restaurante.domain.controller;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException t){
        return ResponseEntity.status(404).body(t.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable t){
        return ResponseEntity.badRequest().body(t.getMessage());
    }

}
