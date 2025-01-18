package com.example.OrdermanagementSystem.Service;

import com.example.OrdermanagementSystem.Model.Order;

import java.util.List;

public interface OrderService {
public Order saveOrder(Order order);

    Order updateOrder(Integer orderId, Order order);

    List<Order> getAllOrders();
}
