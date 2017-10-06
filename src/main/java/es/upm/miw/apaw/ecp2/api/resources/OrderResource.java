package es.upm.miw.apaw.ecp2.api.resources;

import es.upm.miw.apaw.ecp2.api.controller.OrderController;
import es.upm.miw.apaw.ecp2.api.resources.exception.OrderInvalidException;

public class OrderResource {

    public static final String ORDERS = "orders";

    public void createOrder(Integer amount) throws OrderInvalidException {
        if (amount < 0) {
            throw new OrderInvalidException(Integer.toString(amount));
        }
        new OrderController().createOrder(amount);
        
    }
}
