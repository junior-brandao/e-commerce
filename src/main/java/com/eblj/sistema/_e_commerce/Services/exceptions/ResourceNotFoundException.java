package com.eblj.sistema._e_commerce.Services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
  // RuntimeException não exige , em tempo de compilação, o bloco try/catch
  public ResourceNotFoundException(String msg){ super(msg);}
}
