package com.example.OrdermanagementSystem.Service.impl;

import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Model.Grocery;
import com.example.OrdermanagementSystem.Repocitory.GroceryRepocitory;
import com.example.OrdermanagementSystem.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GreoceryServiceImpl implements GroceryService {
    @Autowired
    GroceryRepocitory groceryRepocitory;

    @Override
    public Grocery addGrocery(Grocery grocery) {
        return groceryRepocitory.save(grocery);
    }

    @Override
    public Grocery updateGrocery(Integer grocerId, Grocery grocery) {
        Optional<Grocery>grocery1=groceryRepocitory.findById(grocerId);
        if(grocery1.isPresent()){
            grocery1.get().setName(grocery.getName());
            grocery1.get().setPrice(grocery.getPrice());
            grocery1.get().setQuantity(grocery.getQuantity());
            return groceryRepocitory.save(grocery1.get());
        }
        return null;
    }

    @Override
    public List<Grocery> getAll() {
        return groceryRepocitory.findAll();
    }
}
