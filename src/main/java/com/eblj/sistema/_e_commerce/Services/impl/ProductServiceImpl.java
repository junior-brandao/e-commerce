package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.Services.ProductService;
import com.eblj.sistema._e_commerce.Services.exceptions.DataBaseException;
import com.eblj.sistema._e_commerce.Services.exceptions.ResourceNotFoundException;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.dtos.ProductMinDTO;
import com.eblj.sistema._e_commerce.entities.Product;
import com.eblj.sistema._e_commerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl  implements ProductService {

  @Autowired
  private ProductRepository productRepository;


  @Override
  @Transactional(readOnly = true)
  public ProductDTO findById(Long id){

    //  Optional<Product> resul = productRepository.findById(id);
    Product product = productRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Resource not found."));
    //  ProductDTO productDTO = new ProductDTO(product);
    product.convertoProduct();
    return new ProductDTO(product);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
    Page<Product> product=  productRepository.searchByName(name,pageable);
    return product.map(x -> new ProductMinDTO(x));
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
    try {
      Product entity = productRepository.getReferenceById(id);//objeto monitorado pela JPA, porem não existe consulta ao BD
      copyDtoToEntity(dto, entity);
      productRepository.save(entity);
      return new ProductDTO(entity);
    }catch (EntityNotFoundException e){
       throw new ResourceNotFoundException("Recurso não encontrado");
    }
  }

  @Override
  /*
  Nós tivemos que colocar o SUPPORTS porque o Spring não consegue capturar a exceção
  DataIntegrityViolationException se apenas colocarmos o @Transactional sobre o método.
  */
  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {

    if (!productRepository.existsById(id)) {
      throw new ResourceNotFoundException("Recurso não encontrado");
    }
    try {
      productRepository.deleteById(id);
    }catch(DataIntegrityViolationException e) {
      throw new DataBaseException("Falha de integridade referencial");
    }
  }

  private void copyDtoToEntity(ProductDTO dto, Product entity) {
    entity.setDescription(dto.getDescription());
    entity.setName(dto.getName());
    entity.setImgUrl(dto.getImgUrl());
    entity.setPrice(dto.getPrice());
  }

}
