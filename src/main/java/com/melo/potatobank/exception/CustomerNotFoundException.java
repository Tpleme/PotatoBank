package com.melo.potatobank.exception;

import com.melo.potatobank.error.ErrorMessage;

public class CustomerNotFoundException extends CustomException {

    public CustomerNotFoundException() {
        super(ErrorMessage.NONEXISTENCE_USER.getMessage());
    }
}
