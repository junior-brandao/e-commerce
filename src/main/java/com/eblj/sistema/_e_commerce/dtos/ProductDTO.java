package com.eblj.sistema._e_commerce.dtos;

import com.eblj.sistema._e_commerce.entities.Category;
import com.eblj.sistema._e_commerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

  private long id;
  @Size(min =3 , max =80,message = "Nome deve ter no mínimo {min} e no máximo {max} caracteres.")
  @NotBlank(message = "Campo obrigatório")//não acenta vazio (""), nem espaço em branco("  ") e nem null
  private String name;
  @Size(min = 10, message = "Desceição precisa ter no mínimo {min} caracteres.")
  @NotBlank(message = "Campo obrigatório")
  private String description;
  @NotNull(message = "Campo obrigatório")
  @Positive(message = "Valor deve ser positivo")
  private Double price;
  private  String imgUrl;
  @NotEmpty(message = "Deve ter no mínimo uma categoria")
  private List<CategoryDTO> categories = new ArrayList<>();

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
    for(Category cat: entity.getCategories()){
      categories.add(new CategoryDTO(cat));
    }
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

  public List<CategoryDTO> getCategories() {
    return categories;
  }
}
