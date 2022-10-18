package com.example.Billing.services;

import com.example.Billing.controller.dto.BillInput;
import com.example.Billing.controller.dto.BillOutput;
import com.example.Billing.controller.personalExceptions.DatesIncorrectException;
import com.example.Billing.domain.Bill;
import com.example.Billing.controller.personalExceptions.BillExistsException;
import com.example.Billing.controller.personalExceptions.ClientNotFoundException;
import com.example.Billing.repositories.BillRepository;
import com.example.Billing.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ClientRepository clientRepository;

    public void addBill(BillInput billInput) throws BillExistsException, ClientNotFoundException {
        if (billRepository.existsById(billInput.getBillId())) throw new BillExistsException("The bill already exists.");
        if (!clientRepository.existsById(billInput.getClientId()))
            throw new ClientNotFoundException("The client doesn't exist.");
        billRepository.save(billInput.toDomain());
    }

    public List<BillOutput> getBillsByClient(String clientId) throws ClientNotFoundException {
        if (!clientRepository.existsById(clientId)) throw new ClientNotFoundException("The client doesn't exist.");
        List<Bill> allBills = new ArrayList<>(billRepository.findAll());
        List<BillOutput> listOfBills = new ArrayList<>();
        for (Bill bill : allBills) {
            if (bill.getClientId().equals(clientId)) {
                listOfBills.add(BillOutput.fromDomain(bill));
            }
        }
        return listOfBills;
    }

    public List<BillOutput> getBillsByClientBetweenDates(String clientId, Date startDate, Date endDate) throws ClientNotFoundException, DatesIncorrectException {
        if (startDate.after(endDate)) throw new DatesIncorrectException("The start date is less than the end date");
        List<BillOutput> listOfBills = getBillsByClient(clientId);
        List<BillOutput> listOfBillsByDate = new ArrayList<>();
        for (BillOutput bill : listOfBills) {
            if (bill.getDay().equals(startDate) || bill.getDay().after(startDate) & bill.getDay().before(endDate) || bill.getDay().equals(endDate)) {
                listOfBillsByDate.add(bill);
            }
        }
        return listOfBillsByDate;
    }
}
