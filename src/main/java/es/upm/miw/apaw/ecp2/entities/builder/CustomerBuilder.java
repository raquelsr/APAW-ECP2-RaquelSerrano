package es.upm.miw.apaw.ecp2.entities.builder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.upm.miw.apaw.ecp2.entities.Customer;
import es.upm.miw.apaw.ecp2.entities.Order;

public class CustomerBuilder {
    
    private Customer customer;
    
    public CustomerBuilder (int id, String name) {
        this.customer = new Customer(id, name);
    }
    
    public CustomerBuilder name (String name) {
        this.customer.setName(name);
        return this;
    }
    
    public CustomerBuilder address (String address) {
        this.customer.setAddress(address);
        return this;
    }
    
    public CustomerBuilder date (Calendar date) {
        this.customer.setDate(date);
        return this;
    }
    
    public CustomerBuilder order (Order order) {
        assert order != null;
        List<Order> orders = this.customer.getOrders();
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        this.customer.setOrders(orders);
        return this;   
    }
    
    public Customer build() {
        return this.customer;
    }
}
