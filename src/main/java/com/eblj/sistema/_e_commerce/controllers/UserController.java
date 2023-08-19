package com.eblj.sistema._e_commerce.controllers;

import com.eblj.sistema._e_commerce.Services.impl.UserServiceImpl;
import com.eblj.sistema._e_commerce.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserServiceImpl userService;

  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
  @GetMapping(value = "/logged")
  public ResponseEntity<UserDTO> findMe(){
    UserDTO userDTO = userService.getMe();
    return   ResponseEntity.ok(userDTO);
  }

}
