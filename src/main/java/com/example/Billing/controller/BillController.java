package com.example.Billing.controller;

import com.example.Billing.controller.dto.BillInput;
import com.example.Billing.controller.dto.BillOutput;
import com.example.Billing.controller.personalExceptions.BillExistsException;
import com.example.Billing.controller.personalExceptions.ClientNotFoundException;
import com.example.Billing.controller.personalExceptions.DatesIncorrectException;
import com.example.Billing.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/bills")
    public ResponseEntity<String> addBill(@Valid @RequestBody BillInput billInput) {
        try {
            billService.addBill(billInput);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (BillExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (ClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/bills/{clientId}")
    public ResponseEntity<List<BillOutput>> getBillsByClient(@PathVariable String clientId) {
        try {
            return ResponseEntity.ok(billService.getBillsByClient(clientId));
        } catch (ClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/bills/{clientId}/{startDate}/{endDate}")
    public ResponseEntity<List<BillOutput>> getBillsByClientBetweenDates(@PathVariable String clientId, @PathVariable Date startDate, @PathVariable Date endDate) {
        try {
            return ResponseEntity.ok(billService.getBillsByClientBetweenDates(clientId, startDate, endDate));
        } catch (DatesIncorrectException e) {
            return ResponseEntity.badRequest().build();
        } catch (ClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
