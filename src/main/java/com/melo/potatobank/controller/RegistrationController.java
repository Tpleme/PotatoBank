package com.melo.potatobank.controller;

import com.melo.potatobank.Router;
import com.melo.potatobank.service.CustomerService;
import com.melo.potatobank.exception.*;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.view.LogInView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void registerNewUser(String firstName, String lastName, String email, String phone, String pass,
                                String confirmPass) throws CustomException {

        String[] values = new String[]{firstName,lastName,email,phone,pass,confirmPass};

        for (String value : values) {
            if (value.equals("")) {
                throw new FieldNotFilledException();
            }
        }

        if (customerService.getCustomer(email).isPresent()) {
            throw new CustomerAlreadyExistException();
        }

        if (!pass.equals(confirmPass)) {
            throw new PasswordDontMatchException();
        }

        customerService.saveCustomer(buildCustomer(values));

        //TODO: Falta apresentar aqui uma mensagem/alerta a confirmar o registo

        Router.reRoute(LogInView.class);
    }

    private Customer buildCustomer(String[] fields) {

        Customer customer = new Customer();
        customer.setFirstName(fields[0]);
        customer.setLastName(fields[1]);
        customer.setEmail(fields[2]);
        customer.setPhone(fields[3]);
        customer.setPassword(String.valueOf(fields[4].hashCode()));

        return customer;
    }
}
