package es.upm.miw.apaw.ecp2.controller;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.dao.DaoFactory;
import es.upm.miw.apaw.ecp2.dto.CustomerDto;
import es.upm.miw.apaw.ecp2.entities.Customer;

public class CustomerController {

    public void createCustomer(String name, String address) {
        DaoFactory.getFactory().getCustomerDao().create(new Customer(name,address));
        
    }
    
    private boolean existCustomerId(int customerId) {
        return DaoFactory.getFactory().getCustomerDao().read(customerId) != null;
    }
    

    public Optional<CustomerDto> readCustomer(int customerId) {
       if (existCustomerId(customerId)) {
            return Optional.of(new CustomerDto(DaoFactory.getFactory().getCustomerDao().read(customerId)));
        } else {
            return Optional.empty();
        }
    }


}
