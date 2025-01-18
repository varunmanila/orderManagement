package com.example.OrdermanagementSystem.Repocitory;

import com.example.OrdermanagementSystem.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepocitory extends JpaRepository<Order,Integer> {
}
