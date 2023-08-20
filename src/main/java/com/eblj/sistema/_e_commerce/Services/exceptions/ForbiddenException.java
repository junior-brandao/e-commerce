package com.eblj.sistema._e_commerce.Services.exceptions;

public class ForbiddenException extends RuntimeException{
  // RuntimeException não exige , em tempo de compilação, o bloco try/catch
  public ForbiddenException(String msg){
    super(msg);
  }
}
