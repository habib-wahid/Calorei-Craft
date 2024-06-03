package com.example.caloriecraft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String address;
  private String password;
  private String errorMsg;
}
