package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {
  @Autowired
  DogsRepository dogRepo;
  @Autowired
  DogService dogService;

  @GetMapping("/")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }
  @GetMapping("/dogs")
  public Dog getDogByName(){
    return dogService.getDogByName("Kaya");
  }

  @GetMapping("/dogs/getName")
  public Dog findByName(){
    return dogService.getDogByName("Kaya");
  }

}
