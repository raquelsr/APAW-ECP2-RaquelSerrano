package es.upm.miw.apaw.ecp2.entities;

import java.math.BigDecimal;
import java.util.Calendar;

public class Order {

    private int id;

    private Calendar date;

    private BigDecimal amount;

    public Order(BigDecimal amount) {
        this.date = Calendar.getInstance();
        this.amount = amount;
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
        return "Order [id=" + id + ", date=" + date + ", amount=" + amount + "]";
    }

}
