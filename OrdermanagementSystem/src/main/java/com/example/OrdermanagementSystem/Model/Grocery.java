package com.example.OrdermanagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblgrocery")
@Data
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grocery_id")
    private  Integer id;
    @Column(name = "name")
    private  String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private  Integer quantity;

}
