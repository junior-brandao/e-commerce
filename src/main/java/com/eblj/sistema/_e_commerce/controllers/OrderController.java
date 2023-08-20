package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.impl.OrderServiceImpl;
import com.eblj.sistema._e_commerce.Services.impl.ProductServiceImpl;
import com.eblj.sistema._e_commerce.dtos.OrderDTO;
import com.eblj.sistema._e_commerce.dtos.ProductDTO;
import com.eblj.sistema._e_commerce.dtos.ProductMinDTO;
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
@RequestMapping(value = "/orders")
public class OrderController {

   @Autowired
   private OrderServiceImpl orderService;

   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
   @GetMapping(value = "/{id}")
   public ResponseEntity<OrderDTO> findById(@PathVariable(value = "id") Long id){
     OrderDTO orderDTO = orderService.findById(id);
      return   ResponseEntity.ok(orderDTO);
   }

  @PreAuthorize("hasRole('ROLE_CLIENT')")
  @PostMapping
  public ResponseEntity<OrderDTO> insert( @Valid @RequestBody OrderDTO dto){
    dto =  orderService.insert(dto);
    //return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    //outra forma(cria no header o path o produto salvo)
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }


}
