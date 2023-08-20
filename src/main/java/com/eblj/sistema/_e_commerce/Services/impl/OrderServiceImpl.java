package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.Services.OrderService;
import com.eblj.sistema._e_commerce.Services.exceptions.ResourceNotFoundException;
import com.eblj.sistema._e_commerce.dtos.OrderDTO;
import com.eblj.sistema._e_commerce.dtos.OrderItemDTO;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.entities.Order;
import com.eblj.sistema._e_commerce.entities.OrderItem;
import com.eblj.sistema._e_commerce.entities.Product;
import com.eblj.sistema._e_commerce.entities.User;
import com.eblj.sistema._e_commerce.enuns.OrderStatus;
import com.eblj.sistema._e_commerce.repositories.OrderItemRepository;
import com.eblj.sistema._e_commerce.repositories.OrderRepository;
import com.eblj.sistema._e_commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository repository;
  @Autowired
  private UserServiceImpl userService;
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private OrderItemRepository orderItemRepository;

  @Transactional(readOnly = true)
  @Override
  public OrderDTO findById(Long id) {
    Order order = repository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Resource not found."));
    return new OrderDTO(order);
  }

  @Transactional
  @Override
  public OrderDTO insert(OrderDTO dto) {
    Order order = new Order();
    order.setMoment(Instant.now());
    order.setStatus(OrderStatus.WAITING_PAYMENT);
    User user = userService.authenticated();
    order.setClient(user);

    for(OrderItemDTO itemDTO:dto.getItems()){
      Product product = productRepository.getReferenceById(itemDTO.getProductId());
      OrderItem item = new OrderItem(order,product, itemDTO.getQuantity(), product.getPrice());
      order.getItems().add(item);
    }
    repository.save(order);
    orderItemRepository.saveAll(order.getItems());
    return new OrderDTO(order);
  }
}
