package com.melo.potatobank.service;

import com.melo.potatobank.model.Customer;
import com.melo.potatobank.model.account.Account;
import com.melo.potatobank.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private GenericRepository<Customer> repository;

    @Autowired
    public void setRepository(GenericRepository<Customer> repository) {
        this.repository = repository;
    }

    public Optional<Customer> getCustomer(String email) {
        return repository.findByEmail(email);
    }

    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }

    public double getBalance(Integer id) {

        Optional<Customer> customer = repository.findById(id);

        return customer.get().getAccounts().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
