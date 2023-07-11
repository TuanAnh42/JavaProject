package com.tuananh.manager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private  String description;
    @Column(name = "category_id")
    private  int category_id;
    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;
    @Column(name = "price")
    private float price;
    @Column(name = "discount_id")
    private  int discount_id;
    @Column(name = "create_at")
    private LocalDateTime create_at;
    private boolean status;



}
