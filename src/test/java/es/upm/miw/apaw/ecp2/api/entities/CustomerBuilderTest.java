package es.upm.miw.apaw.ecp2.api.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.entities.Customer;
import es.upm.miw.apaw.ecp2.api.entities.Order;
import es.upm.miw.apaw.ecp2.api.entities.builder.CustomerBuilder;

public class CustomerBuilderTest {

    Order order1;

    Order order2;

    Order order3;

    Calendar calendar;

    @Before
    public void before() {
        calendar = Calendar.getInstance();
        order1 = new Order(new BigDecimal("2"));
        order2 = new Order(new BigDecimal("4"));
        order3 = new Order(new BigDecimal("7"));
    }

    @Test
    public void testCustomerBuilder() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").date(calendar).build();
        assertEquals("Paco", customer.getName());
        assertEquals("Calle Francia", customer.getAddress());
        assertEquals(calendar, customer.getDate());
        assertNull(customer.getOrders());
    }

    @Test
    public void testCreateOrder() {
        assertEquals(new BigDecimal("2"), order1.getAmount());
        //assertEquals(calendar, order1.getDate());
    }
    
    @Test
    public void testDateCustomer() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").build();
        assertNotNull(customer.getDate());
    }

    @Test
    public void testNameCustomer() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").name("Maria").build();
        assertEquals("Maria" , customer.getName());
    }
    
    @Test
    public void testNewOrderCustomerBuilder() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").order(new Order(new BigDecimal("2"))).build();
        assertNotNull(customer.getOrders());
        assertEquals(1, customer.getOrders().size());
    }

    @Test
    public void testCustomerContainOrder() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").address("Calle Francia").order(order1).build();
        assertTrue(customer.containsOrder(order1));
        assertFalse(customer.containsOrder(order2));

        Customer customer2 = new CustomerBuilder("Paco", "Calle Francia").address("Calle Madrid").date(calendar).order(order1).order(order2).build();
        assertNotNull(customer2.getOrders());
        assertTrue(customer2.containsOrder(order1));
        assertTrue(customer2.containsOrder(order2));
        assertFalse(customer2.containsOrder(order3));
    }

    @Test
    public void testOrderContainsNull() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").build();
        assertNull(customer.getOrders());
        assertFalse(customer.containsOrder(null));
    }

    @Test
    public void testOrderContainsNotNull() {
        Customer customer = new CustomerBuilder("Paco", "Calle Francia").order(order3).build();
        assertNotNull(customer.getOrders());
    }

}
