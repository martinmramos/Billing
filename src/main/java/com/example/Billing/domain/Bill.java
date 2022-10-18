package com.example.Billing.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;

@Entity(name = "bills")
public class Bill {

    @Id
    @Positive(message = "The bill ID is negative.")
    private int billId;
    @NotNull(message = "Date is null")
    private Date day;
    @NotNull(message = "Concept is null")
    @NotBlank(message = "Concept is empty")
    private String concept;
    @Digits(integer = 9, fraction = 2)
    private float total;
    @NotBlank(message = "Client is empty")
    @NotNull(message = "Client is null")
    private String clientId;

    public Bill(int billId, Date day, String concept, float total, String clientId) {
        this.billId = billId;
        this.day = day;
        this.concept = concept;
        this.total = total;
        this.clientId = clientId;
    }

    public Bill() {

    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
