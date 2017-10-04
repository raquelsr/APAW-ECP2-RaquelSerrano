package es.upm.miw.apaw.ecp2.api.entities;

import java.util.Calendar;
import java.util.List;

public class Customer {

    private int id;

    private String name;

    private String address;

    private Calendar date;

    private List<Order> orders;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.date = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean containsOrder(Order order) {
        if (order == null) {
            return false;
        }
        return this.orders.contains(order);
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + ", orders=" + orders + "]";
    }

}
