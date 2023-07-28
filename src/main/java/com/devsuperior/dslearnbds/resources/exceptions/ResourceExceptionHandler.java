package com.devsuperior.dslearnbds.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dslearnbds.services.exceptions.DatabaseException;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;

/**
 * Classe que trata exceções globais da aplicação.
 * Essa classe é anotada com '@ControllerAdvice', o que permite que ela seja usada para interceptar
 * exceções lançadas por qualquer controlador da aplicação.
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Trata exceções de 'ResourceNotFoundException'.
     * 
     * @param e       A exceção 'ResourceNotFoundException' que foi lançada.
     * @param request A requisição HTTP onde a exceção foi lançada.
     * @return ResponseEntity contendo os detalhes do erro formatados no padrão 'StandardError'.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }	

    /**
     * Trata exceções de 'DatabaseException'.
     * 
     * @param e       A exceção 'DatabaseException' que foi lançada.
     * @param request A requisição HTTP onde a exceção foi lançada.
     * @return ResponseEntity contendo os detalhes do erro formatados no padrão 'StandardError'.
     */
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Database exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }	

    /**
     * Trata exceções de 'MethodArgumentNotValidException'.
     * 
     * @param e       A exceção 'MethodArgumentNotValidException' que foi lançada.
     * @param request A requisição HTTP onde a exceção foi lançada.
     * @return ResponseEntity contendo os detalhes do erro formatados no padrão 'ValidationError'.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Validation exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        // Itera sobre os erros de validação e adiciona-os ao objeto de erro 'ValidationError'.
        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }	

    /**
     * Trata exceções de 'ForbiddenException'.
     * 
     * @param e       A exceção 'ForbiddenException' que foi lançada.
     * @param request A requisição HTTP onde a exceção foi lançada.
     * @return ResponseEntity contendo os detalhes do erro formatados no padrão 'OAuthCustomError'.
     */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request) {
        OAuthCustomError err = new OAuthCustomError("Forbidden", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }

    /**
     * Trata exceções de 'UnauthorizedException'.
     * 
     * @param e       A exceção 'UnauthorizedException' que foi lançada.
     * @param request A requisição HTTP onde a exceção foi lançada.
     * @return ResponseEntity contendo os detalhes do erro formatados no padrão 'OAuthCustomError'.
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request) {
        OAuthCustomError err = new OAuthCustomError("Unauthorized", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
    }	
}
