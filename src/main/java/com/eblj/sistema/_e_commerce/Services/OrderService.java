package com.eblj.sistema._e_commerce.Services;

import com.eblj.sistema._e_commerce.dtos.OrderDTO;

public interface OrderService {

    OrderDTO findById(Long id);
    OrderDTO insert(OrderDTO dto);
}
