package com.eblj.sistema._e_commerce.controllers.handlers;

import com.eblj.sistema._e_commerce.Services.exceptions.DataBaseException;
import com.eblj.sistema._e_commerce.Services.exceptions.ResourceNotFoundException;
import com.eblj.sistema._e_commerce.dtos.exceptions.CustomError;
import com.eblj.sistema._e_commerce.dtos.exceptions.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
      HttpStatus status = HttpStatus.NOT_FOUND;
      CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(),request.getRequestURI());
      return ResponseEntity.status(status).body(err);
    }

  @ExceptionHandler(DataBaseException.class)
  public ResponseEntity<CustomError> dataBase(DataBaseException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.CONFLICT;
    CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(),request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  //método para captura de erros gerados pelo bean validation
  //esssa exceção é do proprio fremaework(validation), logo não preciso criar a classe
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos",request.getRequestURI());
    //e.getBindingResult().getFieldErrors() retorna um array com os posiveis erros gerados
    for(FieldError f: e.getBindingResult().getFieldErrors()){
      err.addError(f.getField(),f.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(err);
  }


}
