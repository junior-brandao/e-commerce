package com.eblj.sistema._e_commerce.dtos.exceptions;

import com.eblj.sistema._e_commerce.dtos.exceptions.CustomError;
import com.eblj.sistema._e_commerce.dtos.exceptions.FieldMessage;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

  private List<FieldMessage> erros = new ArrayList<>();

  public ValidationError(Instant timestamp, Integer status, String error, String path) {
    super(timestamp, status, error, path);
  }

  public List<FieldMessage> getErros() {
    return erros;
  }

  public void addError(String fieldName, String message){
     erros.add(new FieldMessage(fieldName,message));
  }
}
