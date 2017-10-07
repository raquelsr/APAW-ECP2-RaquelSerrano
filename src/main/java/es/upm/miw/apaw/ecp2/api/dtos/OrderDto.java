package es.upm.miw.apaw.ecp2.api.dtos;

import java.math.BigDecimal;
import java.util.Calendar;

import es.upm.miw.apaw.ecp2.api.entities.Order;

public class OrderDto {


    private int id;

    private Calendar date;

    private BigDecimal amount;

    public OrderDto(Order order) {
        this.date = order.getDate();
        this.amount = order.getAmount();
        this.id = order.getId();
    }

    public int getId() {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"amount\":\"" + amount + ",\"dia\":\"" + Calendar.DAY_OF_WEEK + "\"}";
    }

}
