package es.upm.miw.apaw.ecp2.api.daos.memory;

import es.upm.miw.apaw.ecp2.api.daos.CustomerDao;
import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.OrderDao;


public class DaoMemoryFactory extends DaoFactory {

    private CustomerDao customerDao;

    private OrderDao orderDao;

    @Override
    public CustomerDao getCustomerDao() {
        if (customerDao == null) {
            customerDao = new CustomerDaoMemory();
        }
        return customerDao;
    }

    @Override
    public OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new OrderDaoMemory();
        }
        return orderDao;
    }
}
