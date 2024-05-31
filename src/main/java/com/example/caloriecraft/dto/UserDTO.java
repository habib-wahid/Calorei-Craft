package com.example.caloriecraft.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String address;
  private String password;
}
