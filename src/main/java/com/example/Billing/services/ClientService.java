package com.example.Billing.services;

import com.example.Billing.controller.dto.ClientInput;
import com.example.Billing.controller.personalExceptions.ClientExistsException;
import com.example.Billing.repositories.BillRepository;
import com.example.Billing.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ClientRepository clientRepository;

    public void addClient(ClientInput clientInput) throws ClientExistsException {
        if(clientRepository.existsById(clientInput.getDni())) throw new ClientExistsException("This client already exists.");
        clientRepository.save(clientInput.toDomain());
    }
}
