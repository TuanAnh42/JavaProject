package com.tuananh.manager.dto.request;

import com.tuananh.manager.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
@Data
public class ProductRequest {
    private String name;
    private  String description;
    private  int category_id;
    private float price;
    private  int discount_id;
    private LocalDateTime createdAt;
    private boolean status;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
