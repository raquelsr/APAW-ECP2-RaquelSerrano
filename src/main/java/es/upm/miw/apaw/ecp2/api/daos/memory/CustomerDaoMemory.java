package es.upm.miw.apaw.ecp2.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.ecp2.api.daos.CustomerDao;
import es.upm.miw.apaw.ecp2.api.entities.Customer;

public class CustomerDaoMemory extends GenericDaoMemory<Customer> implements CustomerDao {

    public CustomerDaoMemory() {
        this.setMap(new HashMap<Integer, Customer>());
    }

    @Override
    protected Integer getId(Customer entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Customer entity, Integer id) {
        entity.setId(id);

    }

}
