package com.example.Billing.controller.dto;

import com.example.Billing.domain.Bill;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

public class BillOutput {

    @Positive(message = "The bill ID is negative.")
    private int billId;
    @NotNull(message = "Date is null")
    @NotBlank(message = "Date is empty")
    private Date day;
    @NotNull(message = "Concept is null")
    @NotBlank(message = "Concept is empty")
    private String concept;
    @Digits(integer = 9, fraction = 2)
    private float total;

    public BillOutput(int billId, Date day, String concept, float total) {
        this.billId = billId;
        this.day = day;
        this.concept = concept;
        this.total = total;
    }

    public BillOutput(){

    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public static BillOutput fromDomain(Bill bill){
        return new BillOutput(bill.getBillId(), bill.getDay(), bill.getConcept(), bill.getTotal());
    }
}
