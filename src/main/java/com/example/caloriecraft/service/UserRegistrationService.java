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


  public void addUser() {
    UserRegistration user1 = new UserRegistration("ashiq", "abc@gmail.com", "1235", "Dhaka");
    UserRegistration user2 = new UserRegistration("habib", "xyz@gmail.com", "123552", "Rajshahi");
    UserRegistration user3 = new UserRegistration("kamal", "kamal@gmail.com", "123532", "Khulna");
    users.addAll(List.of(user1, user2, user3));
    System.out.println(users.size());
  }

  public UserRegistration updateUser(UserRegistration userRegistration) {
    for(UserRegistration user: users){
      if(user.getEmail().equals(userRegistration.getEmail())){
        user.setName(userRegistration.getName());
        return user;
      }
    }

    return null;
  }

  public List<UserRegistration> getAll() {
    return users;
  }

  public void deleteUser(String name) {
    UserRegistration userRegistration = null;

    for(UserRegistration user : users){
      if(user.getName().equals(name)){
        userRegistration = user;
      }
    }

    users.remove(userRegistration);
  }
}
