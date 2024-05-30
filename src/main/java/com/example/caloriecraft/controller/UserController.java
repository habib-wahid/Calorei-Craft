package com.example.caloriecraft.controller;

import com.example.caloriecraft.dto.UserDTO;
import com.example.caloriecraft.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  // Rest of the the CRUDS
}
