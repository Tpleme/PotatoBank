package com.melo.potatobank.controller;

import com.melo.potatobank.model.Customer;
import com.melo.potatobank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainAppController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //TODO: try not to make this static, find a way to set the current customer without using static parameters
    private static Customer activeCustomer;

    public static void setActiveCustomer(Customer activeCustomer) {
        MainAppController.activeCustomer = activeCustomer;
    }

    public static Customer getActiveCustomer() {
        return activeCustomer;
    }

    public double getCustomerTotalBalance(String email) {
        return customerService.getBalance(email);
    }
}
