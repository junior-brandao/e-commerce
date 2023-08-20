package com.eblj.sistema._e_commerce.Services;

import com.eblj.sistema._e_commerce.dtos.CategoryDTO;
import com.eblj.sistema._e_commerce.dtos.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO findById(Long id);
    OrderDTO insert(OrderDTO dto);

  interface CategoryService {
      List<CategoryDTO> findAll();
  }
}
