package com.example.caloriecraft.controller;

import com.example.caloriecraft.service.UserRegistrationService;
import com.example.caloriecraft.template.UserRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {

  @Autowired
  private UserRegistrationService userRegistrationService;


  @PostMapping("/save")
  public void saveUser(@RequestBody UserRegistration userRegistration){
    userRegistrationService.saveUser(userRegistration);
  }

  @PutMapping("/update")
  public UserRegistration updateUser(@RequestBody UserRegistration userRegistration){
    return userRegistrationService.updateUser(userRegistration);
  }

  @DeleteMapping("/delete")
  public void deleteUser(@RequestParam(name = "name") String name){
    userRegistrationService.deleteUser(name);
  }

  @GetMapping("/users")
  public List<UserRegistration> getUsers(){
    return userRegistrationService.getAll();
  }
}
