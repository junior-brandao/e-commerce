package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.ProductService;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.entities.Product;
import com.eblj.sistema._e_commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

   @Autowired
   private ProductService productService;
   @GetMapping(value = "/{id}")
   public ProductDTO findById(@PathVariable(value = "id") Long id){
      ProductDTO productDTO = productService.findById(id);
      return productDTO;
   }

}
