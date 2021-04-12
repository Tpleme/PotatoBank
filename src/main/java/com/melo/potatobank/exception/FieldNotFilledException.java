package com.melo.potatobank.exception;

import com.melo.potatobank.error.ErrorMessage;

public class FieldNotFilledException extends CustomException {
    
    public FieldNotFilledException() {
        super(ErrorMessage.FIELDS_NOT_FILLED.getMessage());
    }
}
