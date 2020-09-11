package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.services.AnimalServices;
import com.lambdaschool.javazoos.views.AnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    AnimalServices animalServices;

    //http://localhost:2019/animals/count
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> animalsCount() {
        List<AnimalCount> animals = animalServices.countAnimals();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }
}
