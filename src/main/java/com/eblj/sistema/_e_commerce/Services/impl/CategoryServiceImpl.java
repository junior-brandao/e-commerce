package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.Services.OrderService;
import com.eblj.sistema._e_commerce.dtos.CategoryDTO;
import com.eblj.sistema._e_commerce.entities.Category;
import com.eblj.sistema._e_commerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements OrderService.CategoryService {

  @Autowired
  private CategoryRepository repository;
  @Transactional(readOnly = true)
  @Override
  public List<CategoryDTO> findAll() {
    List<Category> category = repository.findAll();
    return category.stream().map(x-> new CategoryDTO(x)).toList();
  }
}
