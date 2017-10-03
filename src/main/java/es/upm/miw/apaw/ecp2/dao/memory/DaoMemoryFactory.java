package es.upm.miw.apaw.ecp2.dao.memory;

import es.upm.miw.apaw.ecp2.dao.CustomerDao;
import es.upm.miw.apaw.ecp2.dao.DaoFactory;
import es.upm.miw.apaw.ecp2.dao.OrderDao;
import es.upm.miw.apaw.ecp2.entities.Customer;


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
