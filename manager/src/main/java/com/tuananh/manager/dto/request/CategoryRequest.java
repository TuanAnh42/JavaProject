package com.tuananh.manager.dto.request;

import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CategoryRequest {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private boolean status;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
