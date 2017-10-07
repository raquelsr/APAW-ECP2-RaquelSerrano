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
    public void testReadTheme() {
       assertEquals("Paco", customerController.readCustomer(1).get().getName());
    }
    
    @Test
    public void testReadThemeNonExistId() {
       assertFalse(customerController.readCustomer(2).isPresent());
    }
    
    @Test
    public void testCustomeOrders() {
        new CustomerController().createCustomerOrder("Paco", "Madrid", 1);
        assertEquals("Paco", customerController.customerOrder(1).get().getCustomerDto().getName());
        assertNull(customerController.customerOrder(1).get().getOrders());
        
    }
    
}
