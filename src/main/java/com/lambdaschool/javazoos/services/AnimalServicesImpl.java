package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.repositories.AnimalRepository;
import com.lambdaschool.javazoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "animalServices")
public class AnimalServicesImpl implements AnimalServices{

    //autowire repositories
    @Autowired
    AnimalRepository animalrepos;

    //method to save animal
    @Override
    public Animal save(Animal animal) {
        return animalrepos.save(animal);
    }

    @Override
    public List<AnimalCount> countAnimals() {
        List<AnimalCount> animals = animalrepos.countAnimals();
        return animals;
    }
}
