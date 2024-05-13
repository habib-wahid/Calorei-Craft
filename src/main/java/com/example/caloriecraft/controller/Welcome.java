package com.example.caloriecraft.controller;

import com.example.caloriecraft.template.UserTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Welcome {


  @GetMapping("/welcome")
  public String welcome(@RequestParam String name){
    return "welcome " + name;
  }

  @GetMapping("/users")
  public List<UserTemplate> getUser(){

    UserTemplate user1 = new UserTemplate("1", "habib", "abc");
    UserTemplate user2 = new UserTemplate("2", "wahid", "cedf");
    UserTemplate user3 = new UserTemplate("3", "kamal", "xyz");

    List<UserTemplate> userList = new ArrayList<>();
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    return userList;
  }


  @GetMapping("/users/{id}")
  public UserTemplate getSpecificUser(@PathVariable String id){

    UserTemplate user1 = new UserTemplate("1", "habib", "abc");
    UserTemplate user2 = new UserTemplate("2", "wahid", "cedf");
    UserTemplate user3 = new UserTemplate("3", "kamal", "xyz");


    List<UserTemplate> userList = new ArrayList<>();

    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new LinkedList<>();

    List<List<Integer>> m_list = new ArrayList<>();
    m_list.add(list);
    m_list.add(list1);

    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    for(UserTemplate user : userList){
      if(user.getId().equalsIgnoreCase(id)){
        return user;
      }
    }

    return null;
  }
}
