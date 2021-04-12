package com.melo.potatobank.exception;

import com.melo.potatobank.error.ErrorMessage;

public class WrongCredentialException extends CustomException {

    public WrongCredentialException() {
        super(ErrorMessage.WRONG_CREDENTIAL.getMessage());
    }
}
