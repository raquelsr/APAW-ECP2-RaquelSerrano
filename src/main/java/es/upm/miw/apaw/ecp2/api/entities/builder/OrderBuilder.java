package es.upm.miw.apaw.ecp2.api.entities.builder;


import java.math.BigDecimal;
import java.util.Calendar;

import es.upm.miw.apaw.ecp2.api.entities.Order;

public class OrderBuilder {

    private Order order;
    
    public OrderBuilder (BigDecimal amount) {
        this.order = new Order (amount);
    }
    
    public OrderBuilder date (Calendar date) {
        this.order.setDate(date);
        return this;
    }
    
    public OrderBuilder amount (BigDecimal amount) {
        this.order.setAmount(amount);
        return this;
    }
    
    public Order build() {
        return this.order;
    }
}
