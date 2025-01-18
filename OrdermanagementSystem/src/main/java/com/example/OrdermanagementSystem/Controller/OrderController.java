package com.example.OrdermanagementSystem.Controller;

import com.example.OrdermanagementSystem.Model.Order;
import com.example.OrdermanagementSystem.Repocitory.OrderRepocitory;
import com.example.OrdermanagementSystem.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public Order createOrder(@RequestBody Order order){
        return  orderService.saveOrder(order);
    }
    @PostMapping("/update")
    public Order updateOrder(@RequestParam ("orderId")Integer orderId, @RequestBody Order order){
        return  orderService.updateOrder(orderId,order);
    }
    @GetMapping("/list")
    public List<Order> listOrder(){
        return  orderService.getAllOrders();
    }

}
