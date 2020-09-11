package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "telephoneServices")
public class TelephoneServicesImpl implements TelephoneServices{

    @Autowired
    TelephoneRepository phonerepos;
}
