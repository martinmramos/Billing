package com.example.Billing.controller.personalExceptions;

public class ClientExistsException extends Exception{
    public ClientExistsException(String message) {
        super(message);
    }
}
