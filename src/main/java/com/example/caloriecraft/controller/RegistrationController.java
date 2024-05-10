package com.example.caloriecraft.controller;

import com.example.caloriecraft.service.UserRegistrationService;
import com.example.caloriecraft.template.UserRegistration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {

  private final UserRegistrationService userRegistrationService;


  @PostMapping("/save")
  public void saveUser(@RequestBody UserRegistration userRegistration){
    userRegistrationService.saveUser(userRegistration);
  }


}
