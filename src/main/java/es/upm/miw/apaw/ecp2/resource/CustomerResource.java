package es.upm.miw.apaw.ecp2.resource;

import es.upm.miw.apaw.ecp2.controller.CustomerController;
import es.upm.miw.apaw.ecp2.resource.exception.CustomerInvalidException;

public class CustomerResource {

    public static final String CUSTOMERS = "customers";

    public void createCustomer(String name, String address) throws CustomerInvalidException {
        if ((name == null) || (address == null)) {
            throw new CustomerInvalidException("Name: " + name + "Address: " + address);
        } else {
            new CustomerController().createCustomer(name, address);
        }
    }

}
