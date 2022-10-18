package com.example.Billing.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name="clients")
public class Client {

    @Id
    private String dni;
    @NotBlank(message="Name is empty")
    @NotNull(message = "Name is null")
    private String name;
    @Digits(integer = 9, fraction = 0)
    private int phone;

    public Client(String dni, String name, int phone) {
        this.dni = dni;
        this.name = name;
        this.phone = phone;
    }

    public Client(){

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
