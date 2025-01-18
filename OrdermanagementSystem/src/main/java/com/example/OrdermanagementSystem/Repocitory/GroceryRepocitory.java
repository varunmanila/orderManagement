package com.example.OrdermanagementSystem.Repocitory;

import com.example.OrdermanagementSystem.Model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepocitory extends JpaRepository<Grocery,Integer> {
}
