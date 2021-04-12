package com.melo.potatobank.service;

import com.melo.potatobank.Router;
import com.melo.potatobank.exception.CustomException;
import com.melo.potatobank.exception.CustomerNotFoundException;
import com.melo.potatobank.exception.FieldNotFilledException;
import com.melo.potatobank.exception.WrongCredentialException;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.repository.CustomerRepository;
import com.melo.potatobank.view.MainAppView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogInService {

    CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    public void loginUser(String email, String password) throws CustomException {

        if (email.equals("") || password.equals("")) {
            throw new FieldNotFilledException();
        }

        Customer customer = repository.findByEmail(email).orElseThrow(CustomerNotFoundException::new);

        if (!customer.getPassword().equals(String.valueOf(password.hashCode()))) {
            throw new WrongCredentialException();
        }


        //TODO: Se o codigo chegar até aqui, logar o user como current customer e apresentar a main app
        Router.reRoute(MainAppView.class);
    }
}
