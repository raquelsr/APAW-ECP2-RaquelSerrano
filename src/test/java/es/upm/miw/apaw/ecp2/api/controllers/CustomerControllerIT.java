package es.upm.miw.apaw.ecp2.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.controller.CustomerController;
import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;

public class CustomerControllerIT {

    private CustomerController customerController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        customerController = new CustomerController();
        customerController.createCustomer("Paco", "Calle Francia");
    }

    @Test
    public void testReadCustomer() {
       assertEquals("Paco", customerController.readCustomer(1).get().getName());
    }
    
    @Test
    public void testReadCustomerNonExistId() {
       assertFalse(customerController.readCustomer(2).isPresent());
    }
    
    @Test
    public void testCustomerOrdersList() {
        new CustomerController().createCustomerOrder("Paco", "Madrid", 1);
        assertEquals("Paco", customerController.customerOrderList(1).get().getCustomerDto().getName());
        assertNull(customerController.customerOrderList(1).get().getOrders());
        
    }
    
    @Test
    public void testUpdateCustomer() {
        new CustomerController().updateCustomer(customerController.readCustomer(1).get().getId(), "Calle Lechuga");
        assertEquals("Calle Lechuga", customerController.readCustomer(1).get().getAddress());
    }
    
    @Test
    public void testDeleteCustomer() {
        new CustomerController().deleteCustomer(customerController.readCustomer(1).get().getId());
        assertFalse(customerController.readCustomer(1).isPresent());
    }
    
}
