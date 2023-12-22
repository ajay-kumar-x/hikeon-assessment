package com.hikeon.customer.exception;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
