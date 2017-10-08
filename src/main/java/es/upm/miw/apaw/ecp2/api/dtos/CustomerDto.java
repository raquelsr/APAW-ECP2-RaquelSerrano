package es.upm.miw.apaw.ecp2.api.dtos;

import es.upm.miw.apaw.ecp2.api.entities.Customer;

public class CustomerDto {

    private int id;

    private String name;

    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        address = customer.getAddress();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"address\":\"" + address + "\"}";
    }
}
