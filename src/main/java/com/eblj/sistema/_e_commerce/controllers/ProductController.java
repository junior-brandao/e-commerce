package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.impl.ProductServiceImpl;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

   @Autowired
   private ProductServiceImpl productService;

   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_OPERATOR')")
   @GetMapping(value = "/{id}")
   public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id){
      ProductDTO productDTO = productService.findById(id);
      return   ResponseEntity.ok(productDTO);
   }

   @GetMapping
   public ResponseEntity<Page<ProductDTO>> findAll(
           @PageableDefault(page = 0,size = 10,sort = "id", direction = Sort.Direction.ASC)
           @RequestParam(name = "name",defaultValue = "")String name,Pageable pageable){
     Page<ProductDTO> productDTOS = productService.findAll(name,pageable);
     return ResponseEntity.ok(productDTOS);
   }

   @PreAuthorize("hasRole('ROLE_ADMIN')")
   @PostMapping
   public ResponseEntity<ProductDTO> insert( @Valid @RequestBody ProductDTO dto){
     dto =  productService.insert(dto);
     //return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
      //outra forma(cria no header o path o produto salvo)
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
              .buildAndExpand(dto.getId()).toUri();
      return ResponseEntity.created(uri).body(dto);
   }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> update(@PathVariable(value = "id") Long id,@Valid @RequestBody ProductDTO dto) {
    dto =  productService.update(id,dto);
    return ResponseEntity.ok(dto);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete( @PathVariable(value = "id") Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();// retor codigo 204 , não tem corpo na resposta
  }

}
