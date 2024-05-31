package com.example.caloriecraft.service;

import com.example.caloriecraft.dto.UserDTO;
import com.example.caloriecraft.entity.Users;
import com.example.caloriecraft.repository.UserRepository;

import com.example.caloriecraft.utils.User.UserCommon;
import com.example.caloriecraft.utils.exception.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserCommon usersCommon;

  //DTO -> Data Transfer Object

  public List<UserDTO> getAllUser(){
    List<Users> users = userRepository.findAll();
      return convertToUsersDto(users);
  }

  private List<UserDTO> convertToUsersDto(List<Users> users){
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

  public UserDTO createUser(UserDTO userDTO) {
    Users user = new Users();
    if (usersCommon.checkIfDuplicateUserByUserName(userDTO.getUsername()) || usersCommon.checkIfDuplicateUserByEmail(userDTO.getEmail())) {
        throw new DuplicateResourceException("User already exists");
    }
    usersCommon.validateUserInfo(userDTO.getName(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getAddress(), userDTO.getPassword());
    user.setName(userDTO.getName());
    user.setUsername(userDTO.getUsername());
    user.setEmail(userDTO.getEmail());
    user.setPhone(userDTO.getPhone());
    user.setAddress(userDTO.getAddress());
    user.setPassword(userDTO.getPassword());
    userRepository.save(user);
    return userDTO;
  }

    public UserDTO getUserById(Long id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return convertToUserDto(user);
    }

    private UserDTO convertToUserDto(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }

    public void deleteUser(Long id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.delete(user);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        usersCommon.validateUserInfo(userDTO.getName(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getAddress(), userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }
}
