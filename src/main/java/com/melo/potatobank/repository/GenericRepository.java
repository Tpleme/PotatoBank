package com.melo.potatobank.repository;

import com.melo.potatobank.model.Customer;
import com.melo.potatobank.model.account.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenericRepository<T extends AbstractModel> extends JpaRepository<T, Integer> {

    Optional<T> findById(Integer id);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByFirstName(String firstName);

    Optional<Customer> findByLastName(String lastName);

}
