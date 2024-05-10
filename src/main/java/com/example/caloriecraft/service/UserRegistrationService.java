package com.example.caloriecraft.service;

import com.example.caloriecraft.template.UserRegistration;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegistrationService {

  List<UserRegistration> users = new ArrayList<>();

  public void saveUser(UserRegistration userRegistration){
    String name = userRegistration.getName();
    name = name.trim();
    userRegistration.setName(name);
    if(userRegistration.getPhone().length() == 0){
      throw new RuntimeException("Number not valid");
    }
    users.add(userRegistration);
    System.out.println(users);
  }
}
