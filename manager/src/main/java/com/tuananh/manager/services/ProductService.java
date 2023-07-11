package com.tuananh.manager.services;

import com.tuananh.manager.dto.request.ProductRequest;
import com.tuananh.manager.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void create(ProductRequest request);
    void update(ProductRequest request,Long id);
    void delete(Long id);
}
