package com.eblj.sistema._e_commerce.dtos;

import com.eblj.sistema._e_commerce.entities.OrderItem;

public class OrderItemDTO {

  private Long productId;
  private String name;
  private Double price;
  private Integer quantity;
  private String imgURL;
  public OrderItemDTO(Long productId, String name, Double price, Integer quantity,String imgURL) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.imgURL = imgURL;
  }
  public OrderItemDTO(OrderItem entity) {
    productId = entity.getProduct().getId();
    name = entity.getProduct().getName();
    imgURL= entity.getProduct().getImgUrl();
    price = entity.getPrice();
    quantity = entity.getQuantity();
  }

  public Long getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public String getImgURL() {
    return imgURL;
  }

  public Double getSubTotal(){
    return  price*quantity;
  }

}
