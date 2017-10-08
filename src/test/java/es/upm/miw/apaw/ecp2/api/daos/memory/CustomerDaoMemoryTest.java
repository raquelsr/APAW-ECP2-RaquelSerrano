package es.upm.miw.apaw.ecp2.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.api.entities.Customer;
import es.upm.miw.apaw.ecp2.api.entities.builder.CustomerBuilder;


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
    
    @Test
    public void testUpdate() {
        customer.setName("Pepe");
        DaoFactory.getFactory().getCustomerDao().update(customer);
        assertEquals("Pepe", DaoFactory.getFactory().getCustomerDao().read(customer.getId()).getName());
    }

    @Test
    public void testDeleteById() {
        DaoFactory.getFactory().getCustomerDao().deleteById(customer.getId());
        assertNull(DaoFactory.getFactory().getCustomerDao().read(customer.getId()));
    }

    @Test
    public void testFindAll() {
        DaoFactory.getFactory().getCustomerDao().create(new CustomerBuilder("Juan", "Calle Madrid").build());
        assertEquals(2, DaoFactory.getFactory().getCustomerDao().findAll().size());
    }


}
