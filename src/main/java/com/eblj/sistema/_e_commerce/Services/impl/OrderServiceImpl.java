package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.Services.OrderService;
import com.eblj.sistema._e_commerce.Services.exceptions.ResourceNotFoundException;
import com.eblj.sistema._e_commerce.dtos.OrderDTO;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.entities.Order;
import com.eblj.sistema._e_commerce.entities.Product;
import com.eblj.sistema._e_commerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository repository;

  @Transactional(readOnly = true)
  @Override
  public OrderDTO findById(Long id) {
    Order order = repository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Resource not found."));
    return new OrderDTO(order);
  }
}
