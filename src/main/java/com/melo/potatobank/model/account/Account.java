package com.melo.potatobank.model.account;

import com.melo.potatobank.model.Customer;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public abstract class Account extends AbstractModel {

    private double balance;

    @ManyToOne
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

    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    public void credit(double amount) {
        if(canCredit(amount)) {
            balance += amount;
        }
    }

    protected boolean canCredit(double amount) {
        return amount > 0;
    }

    protected boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    @Override
    public String toString() {
        return "Account ID: " + getId() +
                "Account Type: " + getAccountType() +
                "Account Balance: " + getBalance() +
                "From customer: " + getCustomer().getFirstName() +
                " " + getCustomer().getLastName();
    }
}
