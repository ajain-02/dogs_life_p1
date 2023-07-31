package com.example.superheroes.service;
import com.example.superheroes.model.Hero;
import com.example.superheroes.repository.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepo heroRepository;

    public List<Hero> getHeroesStartingWithLetter(String letter){
        String letterParam = letter + "%";
        List<Hero> heroes = heroRepository.findHeroesNameStartingWithLetter(letterParam);
        return heroes;
    }

    public List<Hero> getAllHeroes(){
        return heroRepository.findAll();
    }

    public List<Hero> finTop3ByNamDesc(){
        return heroRepository.findTop3ByOrderByNameDesc();
    }
    public Hero saveHero(Hero hero){
        return heroRepository.save(hero);
    }
}