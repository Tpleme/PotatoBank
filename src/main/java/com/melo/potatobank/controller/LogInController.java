package com.melo.potatobank.controller;

import com.melo.potatobank.Router;
import com.melo.potatobank.service.CustomerService;
import com.melo.potatobank.exception.CustomException;
import com.melo.potatobank.exception.CustomerNotFoundException;
import com.melo.potatobank.exception.FieldNotFilledException;
import com.melo.potatobank.exception.WrongCredentialException;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.view.MainAppView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class LogInController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void loginUser(String email, String password) throws CustomException {

        if (email.equals("") || password.equals("")) {
            throw new FieldNotFilledException();
        }

        Customer customer = customerService.getCustomer(email).orElseThrow(CustomerNotFoundException::new);

        if (!customer.getPassword().equals(String.valueOf(password.hashCode()))) {
            throw new WrongCredentialException();
        }

        MainAppController.setActiveCustomer(customer);
        Router.reRoute(MainAppView.class);
    }
}
