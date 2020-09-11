package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repositories.AnimalRepository;
import com.lambdaschool.javazoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooServices")
public class ZooServicesImpl implements ZooServices{

    @Autowired
    ZooRepository zoorepos;

    @Override
    public Zoo save(Zoo zoo) {
        return zoorepos.save(zoo);
    }

    @Override
    public List<Zoo> findAll() {
        List<Zoo> list = new ArrayList<>();
        zoorepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id) throws EntityNotFoundException {
        return zoorepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Zoo id " + id + " Not Found!"));
    }
}
