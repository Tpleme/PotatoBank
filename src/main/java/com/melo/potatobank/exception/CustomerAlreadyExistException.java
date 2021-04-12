package com.melo.potatobank.exception;

import com.melo.potatobank.error.ErrorMessage;

public class CustomerAlreadyExistException extends CustomException {

    public CustomerAlreadyExistException() {
        super(ErrorMessage.EMAIL_USED.getMessage());
    }
}
