package com.melo.potatobank;

public enum StatusCode {

    ALL_OK("Registration successful, try login in now"),
    WRONG_CREDENTIAL("Wrong credentials, please try again"),
    FIELDS_NOT_FILLED("Please fill all the information fields"),
    PASS_DONT_MATCH("Make sure the passwords match"),
    EMAIL_USED("Email already used"),
    COULD_NOT_CONNECT_TO_SERVER("Could not connect to server, please try again later"),
    COULD_NOT_COMMUNICATE_WITH_DB("Could not communicate with the data base, please try again later");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
