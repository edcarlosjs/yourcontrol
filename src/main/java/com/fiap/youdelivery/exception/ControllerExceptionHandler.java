package com.fiap.youdelivery.exception;


import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private DefaultError error = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        //error.setTimeStamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Entidade não encontrada");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(this.error);

    }
    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<DefaultError> handleAccessDeniedException(AccessDeniedException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        error.setStatus(status.value());
        error.setError("Acesso negado");
        error.setMessage("Você não tem permissão para acessar este recurso.");
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
   
}
