package es.upm.miw.apaw.ecp2.api.dtos;

import es.upm.miw.apaw.ecp2.api.entities.Customer;

public class CustomerDto {
    
    private int id;

    private String name;

    public CustomerDto() {
    }

    public CustomerDto(Customer customer) {
        id = customer.getId();
        name = customer.getName();
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

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }
}