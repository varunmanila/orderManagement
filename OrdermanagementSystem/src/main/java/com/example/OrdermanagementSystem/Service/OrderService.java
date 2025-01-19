package com.example.OrdermanagementSystem.Service;

import com.example.OrdermanagementSystem.Model.Order;
import com.example.OrdermanagementSystem.Model.OrderPojo;

import java.util.List;

public interface OrderService {
public Order saveOrder(OrderPojo order);

    Order updateOrder(Integer orderId, Order order);

    List<Order> getAllOrders();
}
