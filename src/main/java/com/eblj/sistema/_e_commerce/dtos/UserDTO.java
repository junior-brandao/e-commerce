package com.eblj.sistema._e_commerce.dtos;

import com.eblj.sistema._e_commerce.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
  private long id;
  private String name;
  private String email;
  private String phone;
  private LocalDate birthDate;
  private List<String> roles = new ArrayList<>();

  public UserDTO(){}

  public UserDTO(User entity) {
    id = entity.getId();
    name = entity.getName();
    email = entity.getEmail();
    phone = entity.getPhone();
    birthDate = entity.getBirthDate();
    for(GrantedAuthority role: entity.getRoles()){
       roles.add(role.getAuthority());
    }
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public List<String> getRoles() {
    return roles;
  }
}
