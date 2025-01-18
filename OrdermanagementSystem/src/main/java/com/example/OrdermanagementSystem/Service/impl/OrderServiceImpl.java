package com.example.OrdermanagementSystem.Service.impl;

import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Model.Grocery;
import com.example.OrdermanagementSystem.Model.Order;
import com.example.OrdermanagementSystem.Repocitory.CustomersRepocitory;
import com.example.OrdermanagementSystem.Repocitory.GroceryRepocitory;
import com.example.OrdermanagementSystem.Repocitory.OrderRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.OrdermanagementSystem.Service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    OrderRepocitory orderRepocitory;
    @Autowired
    GroceryRepocitory groceryRepocitory;
    @Autowired
    CustomersRepocitory customersRepocitory;

    @Override
    public Order saveOrder(Order order) {
        Customers customer = customersRepocitory.findById(order.getCustomers().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomers(customer);
        List<Integer> groceryIds = order.getGroceryList().stream()
                .map(Grocery::getId)
                .collect(Collectors.toList());
        List<Grocery>groceryList=groceryRepocitory.findAllById(groceryIds);
        order.setGroceryList(groceryList);
        order.setOderDate(LocalDateTime.now());
        return orderRepocitory.save(order);
    }

    @Override
    public Order updateOrder(Integer orderId, Order order) {
        Optional<Order> order1=orderRepocitory.findById(orderId);
        return orderRepocitory.save(order1.get());
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepocitory.findAll();
    }
}
