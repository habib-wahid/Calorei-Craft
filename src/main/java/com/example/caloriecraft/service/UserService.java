package com.example.caloriecraft.service;

import com.example.caloriecraft.dto.UserDTO;
import com.example.caloriecraft.entity.Users;
import com.example.caloriecraft.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  //DTO -> Data Transfer Object

  public List<UserDTO> getAllUser(){
    List<Users> users = userRepository.findAll();
    List<UserDTO> userDto = convertToUserDto(users);
    return userDto;
  }

  private List<UserDTO> convertToUserDto(List<Users> users){
    List<UserDTO> userDTO = new ArrayList<>();
    users.forEach(user -> {
      UserDTO dto = new UserDTO();
      dto.setId(user.getId());
      dto.setName(user.getName());
      dto.setEmail(user.getEmail());
      dto.setAddress(user.getAddress());
      userDTO.add(dto);
    });

    return userDTO;
  }
}
