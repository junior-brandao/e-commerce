package com.eblj.sistema._e_commerce.Services;

import com.eblj.sistema._e_commerce.Services.impl.ProductServiceImpl;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.entities.Product;
import com.eblj.sistema._e_commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService implements ProductServiceImpl {

  @Autowired
  private ProductRepository productRepository;


  @Override
  @Transactional(readOnly = true)
  public ProductDTO findById(Long id){
  //  Optional<Product> resul = productRepository.findById(id);
    Product product = productRepository.findById(id).get();
  //  ProductDTO productDTO = new ProductDTO(product);
    product.convertoProduct();
    return new ProductDTO(product);
  }
}
