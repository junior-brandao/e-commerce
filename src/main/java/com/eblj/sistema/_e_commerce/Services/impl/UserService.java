package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.entities.Role;
import com.eblj.sistema._e_commerce.entities.User;
import com.eblj.sistema._e_commerce.projections.UserDetailsProjection;
import com.eblj.sistema._e_commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  //metodo para buscar no BD os dados de um usuario
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      List<UserDetailsProjection> projection =userRepository.searchUserAndRolesByEmail(username);
      if(projection.size()==0){
        throw new UsernameNotFoundException("User not found");
      }else{
        User user = new User();
        user.setEmail(username);
        user.setPassword(projection.get(0).getPassword());
        for(UserDetailsProjection obj :projection){
          user.addRole(new Role(obj.getRoleId(),obj.getAuthority()));
        }
        return user;
      }
  }
}
