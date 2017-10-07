package es.upm.miw.apaw.ecp2.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.api.controller.CustomerController;
import es.upm.miw.apaw.ecp2.api.dtos.CustomerDto;
import es.upm.miw.apaw.ecp2.api.dtos.CustomerOrderList;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerIdInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerIdNotFoundException;
import es.upm.miw.apaw.ecp2.api.resources.exception.CustomerInvalidException;
import es.upm.miw.apaw.ecp2.api.resources.exception.OrderIdNotFoundException;

public class CustomerResource {

    public static final String CUSTOMERS = "customers";

    public static final String ID = "/{id}";

    public static final String ORDERS = "/orders";

    public void createCustomer(String name, String address) throws CustomerInvalidException {
        if ((name == null) || (address == null)) {
            throw new CustomerInvalidException("Name: " + name + "Address: " + address);
        } else {
            new CustomerController().createCustomer(name, address);
        }
    }

    public CustomerDto readCustomer(Integer customerId) throws CustomerIdInvalidException, CustomerIdNotFoundException {
        this.validateId(customerId);
        Optional<CustomerDto> optional = new CustomerController().readCustomer(customerId);
        return optional.orElseThrow(() -> new CustomerIdNotFoundException(Integer.toString(customerId)));
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

    public void createCustomerOrder(String name, String address, int orderId) throws CustomerInvalidException, OrderIdNotFoundException {
        if ((name == null) || (address == null)) {
            throw new CustomerInvalidException("Name: " + name + "Address: " + address);
        } else {
            if (!new CustomerController().createCustomerOrder(name, address, orderId)) {
                throw new OrderIdNotFoundException(Integer.toString(orderId));
            }
        }
    }

    public CustomerOrderList readCustomerOrder(Integer customerId) throws CustomerIdNotFoundException {
        Optional<CustomerOrderList> optional = new CustomerController().customerOrder(customerId);
        return optional.orElseThrow(() -> new CustomerIdNotFoundException(Integer.toString(customerId)));
    }

    public CustomerDto updateCustomer(int id, String address) throws CustomerInvalidException, CustomerIdInvalidException, CustomerIdNotFoundException {
        this.validateId(id);
        if (address == null) {
            throw new CustomerInvalidException( "Address: " + address);
        } else {
            Optional<CustomerDto> optional = new CustomerController().updateCustomer(id, address);
            return optional.orElseThrow(() -> new CustomerIdNotFoundException(Integer.toString(id)));
        }
    }

}
