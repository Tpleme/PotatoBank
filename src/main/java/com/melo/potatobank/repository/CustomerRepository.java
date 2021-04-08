package com.melo.potatobank.repository;

import com.melo.potatobank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByFirstName(String firstName);

    Optional<Customer> findByLastName(String lastName);

}
