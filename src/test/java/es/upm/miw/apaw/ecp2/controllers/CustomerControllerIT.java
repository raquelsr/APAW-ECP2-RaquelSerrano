package es.upm.miw.apaw.ecp2.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.controller.CustomerController;
import es.upm.miw.apaw.ecp2.dao.DaoFactory;
import es.upm.miw.apaw.ecp2.dao.memory.DaoMemoryFactory;

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
    
}
