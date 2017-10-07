package es.upm.miw.apaw.ecp2.api.dtos;

import java.util.List;

import es.upm.miw.apaw.ecp2.api.entities.Order;

public class CustomerOrderList {

    private CustomerDto customerDto;
    
    private List<Order> orders;
    
    public CustomerOrderList() {
        
    }
    
    public CustomerOrderList(CustomerDto customerDto, List<Order> orders) {
        this.customerDto = customerDto;
        this.orders = orders;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }
    
    public List<Order> getOrders() {
        return orders;
    }
    
    @Override
    public String toString() {
        String respuesta = "{\"id\":" + customerDto.getId() + ",\"name\":\"" + customerDto.getName() + "\",\"pedidos\":" + "[";
        for (Order x : orders) {
            respuesta = respuesta.concat(String.valueOf(x.getId()));
        }
        respuesta = respuesta.concat("]}");
        return respuesta;
    }
}
