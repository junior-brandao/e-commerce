package com.eblj.sistema._e_commerce.Services.impl;

import com.eblj.sistema._e_commerce.dtos.UserDTO;
import com.eblj.sistema._e_commerce.entities.Role;
import com.eblj.sistema._e_commerce.entities.User;
import com.eblj.sistema._e_commerce.projections.UserDetailsProjection;
import com.eblj.sistema._e_commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

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

    protected User authenticated(){
     try{
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
       String username = jwtPrincipal.getClaim("username");
       return userRepository.findByEmail(username).get();
     }catch (Exception e){
       throw new UsernameNotFoundException("User not found");
     }
    }

    @Transactional(readOnly = true)
    public UserDTO getMe(){
       User user = authenticated();
       return new UserDTO(user);
    }
}
