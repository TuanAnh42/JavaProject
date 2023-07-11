package com.tuananh.manager.services;

import com.tuananh.manager.dto.request.CategoryRequest;
import com.tuananh.manager.dto.request.ProductRequest;
import com.tuananh.manager.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    void create(CategoryRequest create);
    void update(CategoryRequest update,Long id);
    void delete(Long id);

}
