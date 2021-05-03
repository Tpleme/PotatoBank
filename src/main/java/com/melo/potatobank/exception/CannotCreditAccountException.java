package com.melo.potatobank.exception;

import com.melo.potatobank.error.ErrorMessage;

public class CannotCreditAccountException extends CustomException{

    public CannotCreditAccountException() {
        super(ErrorMessage.UNABLE_TO_CREDIT_ACCOUNT.getMessage());
    }
}
