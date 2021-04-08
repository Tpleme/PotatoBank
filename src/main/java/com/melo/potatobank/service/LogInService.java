package com.melo.potatobank.service;

import com.melo.potatobank.repository.CustomerRepository;
import com.melo.potatobank.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {

    CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    public StatusCode loginUser(String email, String password) {

        System.out.println("Find by ID: " + repository.findById(6).get());
        System.out.println("Find by email: " + repository.findByEmail("tpleme@hotmail.com").get());
        System.out.println("Find by first name: " + repository.findByFirstName("Leandro").get());
        System.out.println("Find by last name: " + repository.findByLastName("Melo").get());

        return StatusCode.ALL_OK;
    }
}
