package es.upm.miw.apaw.ecp2.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.controller.OrderController;
import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;

public class OrderControllerIT {

    private OrderController orderController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        orderController = new OrderController();
        orderController.createOrder(new BigDecimal("7"));
    }

    @Test
    public void testReadOrder() {
       assertEquals(new BigDecimal("7"), orderController.readOrder(1).get().getAmount());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getCustomerDao().read(2));
    }
    
}
