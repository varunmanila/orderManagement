package com.example.OrdermanagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tblorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;
   @ManyToOne
   @JoinColumn(name = "customer_id")
    private Customers customers;
   @Column(name = "order_date")
  private LocalDateTime oderDate;
    @Column(name = "total_price")
   private Double totalPrice;
    @ManyToMany
    @JoinTable(
            name = "tblorderproduct",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_id"))
    List<Grocery> groceryList;
}
