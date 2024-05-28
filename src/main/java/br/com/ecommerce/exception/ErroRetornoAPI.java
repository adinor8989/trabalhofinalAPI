package br.com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErroRetornoAPI {
/* @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleRecursoNaoEncontrado(ResourceNotFoundException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExcecaoRuimRequest.class)
    public ResponseEntity<?> handleExcecaoRuimRequest(ExcecaoRuimRequest ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesErro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NaoAutorizadoException.class)
    public ResponseEntity<?> handleNaoAutorizado(NaoAutorizadoException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesErro, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalhesErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
