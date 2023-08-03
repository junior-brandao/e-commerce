package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.impl.ProductServiceImpl;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

   @Autowired
   private ProductServiceImpl productService;
   @GetMapping(value = "/{id}")
   public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id){
      ProductDTO productDTO = productService.findById(id);
      return   ResponseEntity.ok(productDTO);
   }

   @GetMapping
   public ResponseEntity<Page<ProductDTO>> findAll(@PageableDefault(page = 0,size = 10,sort = "id", direction = Sort.Direction.ASC)
                                 Pageable pageable){
     Page<ProductDTO> productDTOS = productService.findAll(pageable);
     return ResponseEntity.ok(productDTOS);
   }

   @PostMapping
   public ResponseEntity<ProductDTO> insert( @RequestBody ProductDTO dto){
     dto =  productService.insert(dto);
     //return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
      //outra forma(cria no header o path o produto salvo)
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
              .buildAndExpand(dto.getId()).toUri();
      return ResponseEntity.created(uri).body(dto);
   }

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> update( @PathVariable(value = "id") Long id, @RequestBody ProductDTO dto) {
    dto =  productService.update(id,dto);
    return ResponseEntity.ok(dto);
  }

}
