package com.javaacademy.amauryroyers.domain.order.database;

import com.javaacademy.amauryroyers.domain.order.Order;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrderDatabase {
    private List<Order> orderList;

    public OrderDatabase(){
        orderList = new ArrayList<>();
    }

    public Order addOrder(Order order){
        orderList.add(order);
        return order;
    }
}
