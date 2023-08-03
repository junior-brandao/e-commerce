package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.impl.ProductServiceImpl;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

   @Autowired
   private ProductServiceImpl productService;
   @GetMapping(value = "/{id}")
   public ProductDTO findById(@PathVariable(value = "id") Long id){
      ProductDTO productDTO = productService.findById(id);
      return productDTO;
   }

   @GetMapping
   public Page<ProductDTO> findAll(@PageableDefault(page = 0,size = 10,sort = "id", direction = Sort.Direction.ASC)
                                 Pageable pageable){
     return productService.findAll(pageable);
   }

}
