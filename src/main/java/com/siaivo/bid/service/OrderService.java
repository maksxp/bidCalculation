package com.siaivo.bid.service;

import com.siaivo.bid.model.User;
import com.siaivo.bid.model.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> findOrdersByUser(User user);
    Order findOrderById(int id);
    List<Order> findOrdersByStatus(String orderStatus);
    List<Order> findOrdersByDate(Date dateStart, Date dateEnd);
    void saveOrder(Order order);
    void saveViasatOrder(Order order);
    void closeOrder(Order order);
    void confirmOrder(Order order);
    void editOrder(Order order, int weight);
    List<Order> listAllOrders();
    List<Order> listViasatOrders();
    List<Order> listWarehouseOrders();
}
