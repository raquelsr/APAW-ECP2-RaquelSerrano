package es.upm.miw.apaw.ecp2.api.controller;

import java.math.BigDecimal;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.entities.Order;

public class OrderController {

    public void createOrder(BigDecimal amount) {
        DaoFactory.getFactory().getOrderDao().create(new Order(amount));
        
    }
}
