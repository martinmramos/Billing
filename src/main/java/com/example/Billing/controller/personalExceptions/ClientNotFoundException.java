package com.example.Billing.controller.personalExceptions;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(String message) {
        super(message);
    }
}
