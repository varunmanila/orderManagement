package com.example.OrdermanagementSystem.Service;

import com.example.OrdermanagementSystem.Model.Customers;

import java.util.List;

public interface CustomersService  {
  public Customers saveCustomers(Customers customers);

  Customers updateCustomer(Integer custId,Customers customers);

    List<Customers> getList();
}
