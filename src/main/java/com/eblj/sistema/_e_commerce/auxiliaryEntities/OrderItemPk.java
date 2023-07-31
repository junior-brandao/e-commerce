package com.eblj.sistema._e_commerce.auxiliaryEntities;

import com.eblj.sistema._e_commerce.entities.Order;
import com.eblj.sistema._e_commerce.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/*
 Está classe é uma classe auxiliar para representar
 a chave primária composta.
*/

@Embeddable // não cria a classe como uma entidade no bd
public class OrderItemPk {
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  public  OrderItemPk(){}

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
