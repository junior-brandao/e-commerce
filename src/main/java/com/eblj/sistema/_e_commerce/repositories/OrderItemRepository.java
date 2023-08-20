package com.eblj.sistema._e_commerce.repositories;

import com.eblj.sistema._e_commerce.auxiliaryEntities.OrderItemPk;
import com.eblj.sistema._e_commerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {


}
