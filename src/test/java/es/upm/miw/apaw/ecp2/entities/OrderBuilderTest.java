package es.upm.miw.apaw.ecp2.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import es.upm.miw.apaw.ecp2.entities.builder.OrderBuilder;


public class OrderBuilderTest {

    @Test
    public void testNewOrder() {
        Order order = new OrderBuilder(new BigDecimal("5")).build();
        assertNotNull(order.getDate());
        assertEquals(new BigDecimal("5"), order.getAmount());       
    }
    
    @Test
    public void testOrder() {
        Order order = new OrderBuilder(new BigDecimal("5")).amount(new BigDecimal("7")).build();
        assertEquals(new BigDecimal("7"), order.getAmount());
        assertNotNull(order.getDate());
    }
    
    @Test
    public void testOrderUpdateDate() {
        Calendar now = Calendar.getInstance();
        Order order = new OrderBuilder(new BigDecimal("5")).date(now).amount(new BigDecimal("5")).build();
        assertEquals(now, order.getDate());
        assertEquals(new BigDecimal("5"), order.getAmount());
    }

}
