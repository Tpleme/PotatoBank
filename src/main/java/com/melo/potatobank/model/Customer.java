package com.melo.potatobank.model;

import com.melo.potatobank.model.account.AbstractModel;
import com.melo.potatobank.model.account.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Customer extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Account> accounts = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setCustomer(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setCustomer(null);
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() +
                ", Name: " + firstName + " " + lastName +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Accounts: " + accounts.toString();
    }
}
