package com.example.OrdermanagementSystem.Controller;

import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersControllers {
    @Autowired
    CustomersService customersService;
    @PostMapping("/save")
    public Customers saveCustomers(@RequestBody Customers customers){
       return customersService.saveCustomers(customers);
    }


    @PutMapping("/update")
    public Customers updateCustomers( @RequestParam ("custId")Integer custId,@RequestBody Customers customers){
        return customersService.updateCustomer(custId,customers);
    }
    @GetMapping("/list")
    public List<Customers> customersList(){
        return customersService.getList();
    }


}
