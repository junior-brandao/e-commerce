package com.eblj.sistema._e_commerce.dtos;

import com.eblj.sistema._e_commerce.entities.Product;
import org.springframework.beans.BeanUtils;

public class ProductDTO {

  private long id;
  private String name;
  private String description;
  private Double price;
  private  String imgUrl;

  public ProductDTO(){}

  public ProductDTO(long id, String name, String description, Double price, String imgUrl) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
  }

  public ProductDTO(Product entity) {
    id = entity.getId();
    name = entity.getName();
    description = entity.getDescription();
    price = entity.getPrice();
    imgUrl = entity.getImgUrl();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Double getPrice() {
    return price;
  }

  public String getImgUrl() {
    return imgUrl;
  }


}
