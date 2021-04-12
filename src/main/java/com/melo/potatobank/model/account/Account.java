package com.melo.potatobank.model.account;

import com.melo.potatobank.model.Customer;

public abstract class Account {

    private double balance;
    private Customer customer;

    public abstract AccountType getAccountType();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
