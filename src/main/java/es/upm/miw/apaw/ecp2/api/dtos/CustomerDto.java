package es.upm.miw.apaw.ecp2.api.dtos;

import java.util.Calendar;

import es.upm.miw.apaw.ecp2.api.entities.Customer;

public class CustomerDto {
    
    private int id;

    private String name;
    
    private String address;
    
    private Calendar date;

    public CustomerDto() {
    }

    public CustomerDto(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        address = customer.getAddress();
        date = customer.getDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + ",\"address\":\"" + address + "\"}";
    }
}