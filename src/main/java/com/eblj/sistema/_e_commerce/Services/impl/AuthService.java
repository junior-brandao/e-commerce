package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.Services.exceptions.ForbiddenException;
import com.eblj.sistema._e_commerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//clase para regras de negocios para controle de acesso
@Service
public class AuthService {

  @Autowired
  private UserServiceImpl userService;

   //testa se o user logado é admin ou nem for o mesmo usuario retornado, lança uma exceção
   public void validateSelfOrAdmin(long userId) {
     User me = userService.authenticated();
     if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
       throw new ForbiddenException("Access denied");
     }
   }
}
