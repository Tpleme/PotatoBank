package com.melo.potatobank.service;

import com.melo.potatobank.Router;
import com.melo.potatobank.exception.*;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.repository.CustomerRepository;
import com.melo.potatobank.view.LogInView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    public void registerNewUser(String firstName, String lastName, String email, String phone, String pass,
                                String confirmPass) throws CustomException {

        String[] values = new String[]{firstName,lastName,email,phone,pass,confirmPass};

        for (String value : values) {
            if (value.equals("")) {
                throw new FieldNotFilledException();
            }
        }

        if (repository.findByEmail(email).isPresent()) {
            throw new CustomerAlreadyExistException();
        }

        if (!pass.equals(confirmPass)) {
            throw new PasswordDontMatchException();
        }

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setPassword(String.valueOf(pass.hashCode()));

        repository.save(customer);

        //TODO: Falta apresentar aqui uma mensagem/alerta a confirmar o registo

        Router.reRoute(LogInView.class);
    }
}
