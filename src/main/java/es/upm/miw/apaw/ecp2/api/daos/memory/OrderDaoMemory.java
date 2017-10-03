package es.upm.miw.apaw.ecp2.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.ecp2.api.daos.OrderDao;
import es.upm.miw.apaw.ecp2.api.entities.Order;

public class OrderDaoMemory extends GenericDaoMemory<Order> implements OrderDao{


    public OrderDaoMemory() {
        this.setMap(new HashMap<Integer, Order>());
    }

    @Override
    protected Integer getId(Order entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Order entity, Integer id) {
        entity.setId(id);

    }
}
