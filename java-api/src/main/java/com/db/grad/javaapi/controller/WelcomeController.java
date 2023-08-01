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
  DogService dogsService;

  @GetMapping("/dogsAll")
    public List <Dog> getAllDogs() {
      return dogsService.getAllDogs();
    }
  @GetMapping("/getName/{name}")
  public Dog findByName(@PathVariable String name){
    return dogsService.getDogByName(name);
  }
  @GetMapping("/gotDogID/{id}")
  public Dog findById(@PathVariable long id){
    return dogsService.getDogById(id);
  }
  @GetMapping("/getNoDogs")
  public Long getNoDogs() {
    return dogsService.getNoOfDogs();
  }

  @GetMapping("/deleteDogID/{id}")
  public boolean deleteDog(@PathVariable long id){
    return dogsService.removeDog(id);
  }

  @GetMapping("/addDog/{name}")
  public Dog addDog(@PathVariable String name) {
    Dog dog = new Dog();
    dog.setName(name);
    return dogsService.addDog(dog);
  }

}
