package com.eblj.sistema._e_commerce.Services;

import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.dtos.ProductMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
   ProductDTO findById(Long id);
   Page<ProductMinDTO> findAll(String name, Pageable pageable);
   ProductDTO insert(ProductDTO dto);
   ProductDTO update(Long id,ProductDTO dto);
   void delete(Long id);

}
