package es.upm.miw.apaw.ecp2.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.api.controller.CustomerController;
import es.upm.miw.apaw.ecp2.api.dtos.CustomerDto;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerIdInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;

public class CustomerResource {

    public static final String CUSTOMERS = "customers";

    public static final String ID = "/{id}";

    public void createCustomer(String name, String address) throws CustomerInvalidException {
        if ((name == null) || (address == null)) {
            throw new CustomerInvalidException("Name: " + name + "Address: " + address);
        } else {
            new CustomerController().createCustomer(name, address);
        }
    }

    public CustomerDto readCustomer(Integer customerId) throws CustomerIdInvalidException, CustomerInvalidException {
        this.validateId(customerId);
        Optional<CustomerDto> optional = new CustomerController().readCustomer(customerId);
        return optional.orElseThrow(() -> new CustomerIdInvalidException(Integer.toString(customerId)));
    }
    
    private void validateId(Integer customerId) throws CustomerIdInvalidException {
        if (customerId < 0) {
            throw new CustomerIdInvalidException(Integer.toString(customerId));
        }
    }

    public void deleteCustomer(int id ) throws CustomerIdInvalidException {
        this.validateId(id);
        new CustomerController().deleteCustomer(id);
    }

}
