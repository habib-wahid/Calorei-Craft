package com.example.caloriecraft;

import com.example.caloriecraft.service.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalorieCraftApplication implements CommandLineRunner {

  @Autowired
  private UserRegistrationService userRegistrationService;

  public static void main(String[] args) {
    SpringApplication.run(CalorieCraftApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    userRegistrationService.addUser();
  }
}
