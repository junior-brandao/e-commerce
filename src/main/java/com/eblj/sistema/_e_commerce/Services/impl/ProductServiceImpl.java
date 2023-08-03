package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.Services.ProductService;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.entities.Product;
import com.eblj.sistema._e_commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl  implements ProductService {

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

  @Override
  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(Pageable pageable) {
    Page<Product> product=  productRepository.findAll(pageable);
    return product.map(x -> new ProductDTO(x));
  }

  @Override
  @Transactional
  public ProductDTO insert(ProductDTO dto) {
    Product entity = new Product();
    copyDtoToEntity(dto,entity);
    productRepository.save(entity);
    return new ProductDTO(entity);
  }

  @Override
  @Transactional
  public ProductDTO update(Long id,ProductDTO dto){
    Product entity = productRepository.getReferenceById(id);//objeto monitorado pela JPA, porem não existe consulta ao BD
    copyDtoToEntity(dto,entity);
    productRepository.save(entity);
    return new ProductDTO(entity);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  private void copyDtoToEntity(ProductDTO dto, Product entity) {
    entity.setDescription(dto.getDescription());
    entity.setName(dto.getName());
    entity.setImgUrl(dto.getImgUrl());
    entity.setPrice(dto.getPrice());
  }

}
