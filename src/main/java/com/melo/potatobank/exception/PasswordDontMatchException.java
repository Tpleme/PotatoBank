package com.melo.potatobank.exception;

import com.melo.potatobank.error.ErrorMessage;

public class PasswordDontMatchException extends CustomException {

    public PasswordDontMatchException() {
        super(ErrorMessage.PASS_DONT_MATCH.getMessage());
    }
}
