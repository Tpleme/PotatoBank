package com.melo.potatobank.service;

import com.melo.potatobank.exception.CannotCreditAccountException;
import com.melo.potatobank.model.account.Account;
import com.melo.potatobank.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private GenericRepository<Account> repository;

    @Autowired
    public void setRepository(GenericRepository<Account> repository) {
        this.repository = repository;
    }

    public void saveAccount(Account account) {
        repository.save(account);
    }

    public void creditAccount(Account account, double amount) throws CannotCreditAccountException{

        if(account.canCredit(amount)) {
            account.credit(amount);
            return;
        }

        throw new CannotCreditAccountException();
    }
}
