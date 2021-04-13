package com.melo.potatobank.model.account;

import javax.persistence.Entity;

@Entity
public class SavingAccount extends Account {

    public static final double MIN_BALANCE = 100;

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVING;
    }

    @Override
    protected boolean canDebit(double amount) {
        return super.canDebit(amount) && (getBalance() - amount) >= MIN_BALANCE;
    }
}
