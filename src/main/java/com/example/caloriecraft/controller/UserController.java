package com.example.caloriecraft.controller;

import com.example.caloriecraft.dto.UserDTO;
import com.example.caloriecraft.entity.Users;
import com.example.caloriecraft.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  List<UserDTO> getAllUser(){
    return userService.getAllUser();
  }

  @PostMapping("/users/register")
  UserDTO createUser(@RequestBody UserDTO userDTO){
      return userService.createUser(userDTO);
  }

  @GetMapping("/users/{id}")
  public UserDTO getUserById(@PathVariable Long id) {
      return userService.getUserById(id);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Long id) {
      userService.deleteUser(id);
  }

  @PutMapping("/users/{id}")
  public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
      return userService.updateUser(id, userDTO);
  }
}
