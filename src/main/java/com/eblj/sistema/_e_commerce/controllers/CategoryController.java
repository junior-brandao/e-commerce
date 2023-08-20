package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.impl.CategoryServiceImpl;
import com.eblj.sistema._e_commerce.dtos.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

   @Autowired
   private CategoryServiceImpl  categoryService;

   @GetMapping
   public ResponseEntity<List<CategoryDTO>> findAll(){
     List<CategoryDTO> categoryDTO = categoryService.findAll();
     return ResponseEntity.ok(categoryDTO);
   }

}
