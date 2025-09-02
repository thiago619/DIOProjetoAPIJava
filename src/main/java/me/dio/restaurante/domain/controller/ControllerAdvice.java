package me.dio.restaurante.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable t){
        return ResponseEntity.badRequest().body(t.getMessage());
    }

}
