package com.example.OrdermanagementSystem.Controller;

import com.example.OrdermanagementSystem.Model.Customers;
import com.example.OrdermanagementSystem.Model.Grocery;
import com.example.OrdermanagementSystem.Service.CustomersService;
import com.example.OrdermanagementSystem.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grocery")
public class GroceryCOntroller {
    @Autowired
    GroceryService groceryService;
    @PostMapping("/save")
    public Grocery saveCustomers(@RequestBody Grocery grocery){
        return groceryService.addGrocery(grocery);
    }


    @PutMapping("/update")
    public Grocery updateCustomers( @RequestParam ("groceryId")Integer groceryId,@RequestBody  Grocery grocery){
        return groceryService.updateGrocery(groceryId,grocery);
    }
    @GetMapping("/list")
    public List<Grocery> groceryList(){
        return  groceryService.getAll();
    }
}
