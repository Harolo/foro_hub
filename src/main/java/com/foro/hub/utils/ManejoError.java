package com.foro.hub.utils;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejoError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manejoError404() {
        return new ResponseEntity<>("El recurso no fue encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity manejoError500() {
        return new ResponseEntity<>("El tópico con el mismo título y mensaje ya existe.", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manejoError400(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(e.getFieldErrors().stream().map(error -> new DatosErrorValidacion(error.getField(), error.getDefaultMessage())).toList(),HttpStatus.BAD_REQUEST);
    }
    public record DatosErrorValidacion(String campo, String error) {}


}
