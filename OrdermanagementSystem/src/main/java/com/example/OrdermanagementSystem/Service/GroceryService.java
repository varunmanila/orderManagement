package com.example.OrdermanagementSystem.Service;

import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Model.Grocery;

import java.util.List;

public interface GroceryService  {

    Grocery addGrocery(Grocery customers);

    Grocery updateGrocery(Integer custId, Grocery grocery);

    List<Grocery> getAll();
}
