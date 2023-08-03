package com.eblj.sistema._e_commerce.enuns;

public enum OrderStatus {

  WAITING_PAYMENT(0),
  PAID(1),
  SHIPPED(2),
  DELIVERED(3),
  CANCELD(4);

  private int code;

  private OrderStatus(int code){
    this.code= code;
  }

  public int getCode() {;
    return code;
  }

  public static OrderStatus valueOf(int code) {
    for(OrderStatus value: OrderStatus.values()) {
      if(value.code==code) {
        return value;
      }
    }
    throw new IllegalArgumentException("Invalid order status code");
  }

}
