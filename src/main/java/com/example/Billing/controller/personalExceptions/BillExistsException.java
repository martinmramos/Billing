package com.example.Billing.controller.personalExceptions;

public class BillExistsException extends Exception{
    public BillExistsException(String message) {
        super(message);
    }
}
