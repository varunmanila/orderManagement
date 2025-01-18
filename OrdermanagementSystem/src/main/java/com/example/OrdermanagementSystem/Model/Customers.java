package com.example.OrdermanagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tblcustomers")
@Data
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address",length = 200)
    private String address;
    @Column(name = "mobile")
    private String mobile;
}
