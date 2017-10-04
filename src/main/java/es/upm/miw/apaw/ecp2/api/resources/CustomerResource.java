package es.upm.miw.apaw.ecp2.api.resources;

import es.upm.miw.apaw.ecp2.api.controller.CustomerController;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;

public class CustomerResource {

    public static final String CUSTOMERS = "customers";
    public static final String ID = "id";

    public void createCustomer(String name, String address) throws CustomerInvalidException {
        if ((name == null) || (address == null)) {
            throw new CustomerInvalidException("Name: " + name + "Address: " + address);
        } else {
            new CustomerController().createCustomer(name, address);
        }
    }

}
