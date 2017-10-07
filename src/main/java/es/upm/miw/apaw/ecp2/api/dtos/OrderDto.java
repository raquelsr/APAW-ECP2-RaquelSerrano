package es.upm.miw.apaw.ecp2.api.dtos;

import java.math.BigDecimal;

import es.upm.miw.apaw.ecp2.api.entities.Order;

public class OrderDto {

    private int id;

    private BigDecimal amount;

    public OrderDto(Order order) {
        this.amount = order.getAmount();
        this.id = order.getId();
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"amount\":\"" + amount + "\"}";
    }

}
