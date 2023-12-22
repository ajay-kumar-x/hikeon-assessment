package com.hikeon.customer.exception;

public class EmailAlreadyExistsException extends Exception{
    public EmailAlreadyExistsException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
