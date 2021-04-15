package com.melo.potatobank.controller;

import com.melo.potatobank.model.Customer;
import org.springframework.stereotype.Controller;

@Controller
public class MainAppController {

    //TODO: try not to make this static, find a way to set the current customer without using static parameters
    private static Customer activeCustomer;

    public static void setActiveCustomer(Customer activeCustomer) {
        MainAppController.activeCustomer = activeCustomer;
    }

    public static Customer getActiveCustomer() {
        return activeCustomer;
    }
}
