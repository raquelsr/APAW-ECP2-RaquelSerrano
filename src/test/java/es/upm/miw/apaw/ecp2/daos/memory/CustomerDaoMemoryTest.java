package es.upm.miw.apaw.ecp2.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.dao.DaoFactory;
import es.upm.miw.apaw.ecp2.dao.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.entities.Customer;
import es.upm.miw.apaw.ecp2.entities.builder.CustomerBuilder;

public class CustomerDaoMemoryTest {

    private Customer customer;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        customer = new CustomerBuilder("Paco", "CalleFrancia").build();
        DaoFactory.getFactory().getCustomerDao().create(customer);
    }

    @Test
    public void testReadCustomer() {
        assertEquals("Paco", DaoFactory.getFactory().getCustomerDao().read(1).getName());
    }
    
    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getCustomerDao().read(2));
    }

}
