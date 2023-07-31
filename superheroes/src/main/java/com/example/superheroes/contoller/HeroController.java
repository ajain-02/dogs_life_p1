package com.example.superheroes.contoller;

import com.example.superheroes.model.Hero;
import com.example.superheroes.repository.HeroRepo;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    HeroService heroService;
    @Autowired
    HeroRepo heroRepo;


    @GetMapping("/heroes")
    public List<Hero> getAllHeroes(){
        return heroService.getAllHeroes();
    }
    @GetMapping("/heroes/{letter}")
    public List<Hero> getHeroLetter(@PathVariable String letter){
        return heroService.getHeroesStartingWithLetter(letter);
    }

    @PostMapping("/heroes")
    public HttpStatus postHero(@RequestBody Hero hero){
        Hero res = heroService.saveHero(hero);
        if (res == null){
            return HttpStatus.PRECONDITION_FAILED;
        }else{
            return  HttpStatus.CREATED;
        }
    }
}
