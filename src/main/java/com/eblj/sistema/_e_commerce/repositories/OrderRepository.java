package com.eblj.sistema._e_commerce.repositories;

import com.eblj.sistema._e_commerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

  Optional<Order> findById(Long id);

}
