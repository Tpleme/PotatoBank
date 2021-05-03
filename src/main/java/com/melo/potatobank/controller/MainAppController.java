package com.melo.potatobank.controller;
import com.melo.potatobank.exception.CannotCreditAccountException;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.model.account.Account;
import com.melo.potatobank.service.AccountService;
import com.melo.potatobank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainAppController {

    private CustomerService customerService;
    private AccountService accountService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    //TODO: try not to make this static, find a way to set the current customer without using static parameters
    private static Customer activeCustomer;

    public static void setActiveCustomer(Customer activeCustomer) {
        MainAppController.activeCustomer = activeCustomer;
    }

    public static Customer getActiveCustomer() {
        return activeCustomer;
    }

    public double getCustomerTotalBalance(Customer customer) {
        return customerService.getBalance(customer);
    }

    public void creditAccount(Account account, double amount) throws CannotCreditAccountException {
        accountService.creditAccount(account,amount);
    }
}
