package com.example.Billing.controller;

import com.example.Billing.controller.dto.ClientInput;
import com.example.Billing.controller.personalExceptions.ClientExistsException;
import com.example.Billing.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<String> addClient(@Valid @RequestBody ClientInput clientInput){
        try{
            clientService.addClient(clientInput);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ClientExistsException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
