package es.upm.miw.apaw.ecp2.api.daos.memory;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.entities.Order;
import es.upm.miw.apaw.ecp2.api.entities.builder.OrderBuilder;

public class OrderDaoMemoryTest {

    private Order order;
    
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        order = new OrderBuilder(new BigDecimal("7")).build();
        DaoFactory.getFactory().getOrderDao().create(order);
    }

    @Test
    public void testReadOrder() {
        assertEquals(new BigDecimal("7"), DaoFactory.getFactory().getOrderDao().read(1).getAmount());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getCustomerDao().read(2));
    }


}
