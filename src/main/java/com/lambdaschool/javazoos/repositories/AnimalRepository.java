package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.AnimalCount;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animaltype, a.animalid, COUNT(z.zooid) zoocount " +
            "FROM zooanimals z RIGHT JOIN animals a " +
            "ON z.animalid = a.animalid " +
            "GROUP BY a.animaltype, z.animalid", nativeQuery = true)
    List<AnimalCount> countAnimals();
}
