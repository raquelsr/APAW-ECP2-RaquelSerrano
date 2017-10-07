package es.upm.miw.apaw.ecp2.api.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.dtos.OrderDto;
import es.upm.miw.apaw.ecp2.api.entities.Order;

public class OrderController {

    public void createOrder(BigDecimal amount) {
        DaoFactory.getFactory().getOrderDao().create(new Order(amount));
        
    }

     private boolean existOrderId(int orderId) {
        return DaoFactory.getFactory().getOrderDao().read(orderId) != null;
    }
    

    public Optional<OrderDto> readOrder(int orderId) {
       if (existOrderId(orderId)) {
            return Optional.of(new OrderDto(DaoFactory.getFactory().getOrderDao().read(orderId)));
        } else {
            return Optional.empty();
        }
    }

    public List<OrderDto> readListOrders() {
        List<Order> orderList = DaoFactory.getFactory().getOrderDao().findAll();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            orderDtoList.add(new OrderDto(order));
        }
        return orderDtoList;
    }
}
