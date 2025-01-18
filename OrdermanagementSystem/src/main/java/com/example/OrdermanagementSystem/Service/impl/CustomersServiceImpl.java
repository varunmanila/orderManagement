package com.example.OrdermanagementSystem.Service.impl;
import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Repocitory.CustomersRepocitory;
import com.example.OrdermanagementSystem.Service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomersServiceImpl  implements CustomersService {
    @Autowired
    CustomersRepocitory customersRepocitory;

    @Override
    public Customers saveCustomers(Customers customers) {

        return customersRepocitory.save(customers);
    }

    @Override
    public Customers updateCustomer(Integer custId, Customers customers) {
       Optional<Customers> customers1= customersRepocitory.findById(custId);
       if(customers1.isPresent()){
           customers1.get().setAddress(customers.getAddress());
           customers1.get().setName(customers.getName());
           customers1.get().setEmail(customers.getEmail());
           customers1.get().setMobile(customers.getMobile());
           customersRepocitory.save(customers1.get());
         return customers1.get();
       }else {
           return null;
       }
    }

    @Override
    public List<Customers> getList() {
       return  customersRepocitory.findAll();
    }
}
