package es.upm.miw.apaw.ecp2.api.controller;

import java.util.Optional;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.dtos.CustomerDto;
import es.upm.miw.apaw.ecp2.api.entities.Customer;
import es.upm.miw.apaw.ecp2.api.entities.Order;
import es.upm.miw.apaw.ecp2.api.entities.builder.CustomerBuilder;

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

    public void deleteCustomer(int id) {
        DaoFactory.getFactory().getCustomerDao().deleteById(id);
    }

    public boolean createCustomerOrder(String name, String address, int orderId) {
        Order order = DaoFactory.getFactory().getOrderDao().read(orderId);
        if (order != null) {
            Customer customer = new CustomerBuilder(name, address).order(order).build();
            DaoFactory.getFactory().getCustomerDao().create(customer);
            return true;
        } else {
            return false;
        }
    }


}
