package com.example.OrdermanagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrderPojo {
    private Integer customer_id;
    Map<Integer,Integer> groceryList=new HashMap<>();
}
