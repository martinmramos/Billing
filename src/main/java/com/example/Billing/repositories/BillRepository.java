package com.example.Billing.repositories;

import com.example.Billing.controller.dto.BillOutput;
import com.example.Billing.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List <Bill>findByClientId(String clientID);
    List <Bill>findByClientIdAndDayBetween(String clientId, Date startDate, Date endDate);
}
