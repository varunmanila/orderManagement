package com.example.OrdermanagementSystem.Service.impl;

import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Model.Grocery;
import com.example.OrdermanagementSystem.Model.Order;
import com.example.OrdermanagementSystem.Model.OrderPojo;
import com.example.OrdermanagementSystem.Repocitory.CustomersRepocitory;
import com.example.OrdermanagementSystem.Repocitory.GroceryRepocitory;
import com.example.OrdermanagementSystem.Repocitory.OrderRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.OrdermanagementSystem.Service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
    public Order saveOrder(OrderPojo order) {
        Order o=new Order();
        Customers customer = customersRepocitory.findById(order.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        o.setCustomers(customer);
        Double totalPrice=0.00;
        List<Grocery>groceryList=groceryRepocitory.findAllById(order.getGroceryList().keySet());

        for (Grocery g : groceryList) {
            Integer quantity = order.getGroceryList().get(g.getId());
            Double price = g.getPrice();
            totalPrice += (quantity * price);
        }
        o.setTotalPrice(totalPrice);
        o.setGroceryList(groceryList);
        o.setOderDate(LocalDateTime.now());
        return orderRepocitory.save(o);
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
