package es.upm.miw.apaw.ecp2.api.resources;

import java.math.BigDecimal;

import es.upm.miw.apaw.ecp2.api.controller.OrderController;
import es.upm.miw.apaw.ecp2.api.resources.exception.OrderInvalidException;

public class OrderResource {

    public static final String ORDERS = "orders";

    public void createOrder(Double amountAux) throws OrderInvalidException {
        if (amountAux < 0) {
            throw new OrderInvalidException(Double.toString(amountAux));
        }
        BigDecimal amount = new BigDecimal(amountAux);
        new OrderController().createOrder(amount);
        
    }
}
