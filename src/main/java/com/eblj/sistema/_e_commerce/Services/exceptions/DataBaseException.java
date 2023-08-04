package com.eblj.sistema._e_commerce.Services.exceptions;

public class DataBaseException extends RuntimeException{
  // RuntimeException não exige , em tempo de compilação, o bloco try/catch
  public DataBaseException(String msg){ super(msg);}
}
