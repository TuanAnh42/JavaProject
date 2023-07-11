package com.tuananh.manager.services.impl;

import com.tuananh.manager.dto.request.CategoryRequest;
import com.tuananh.manager.model.Category;
import com.tuananh.manager.repositories.CategoryRepository;
import com.tuananh.manager.services.CategoryService;
import com.tuananh.manager.services.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private  final ProductService productService;
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(ProductService productService,CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAll() {

        return null;
    }

    @Override
    public void create(CategoryRequest create) {
        Category category = new Category();
        category.setName(create.getName());
        category.setDescription(create.getDescription());
        category.setCreate_at(create.getCreatedAt());
        category.setStatus(true);
        categoryRepository.save(category);
    }

    @Override
    public void update(CategoryRequest update, Long id) {
        Category category = categoryRepository.findbyId(id);
        if(category==null){
            try{
                throw new ChangeSetPersister.NotFoundException();
            }catch (ChangeSetPersister.NotFoundException e){
                throw new RuntimeException();
            }
        }
        category.setName(update.getName());
        category.setDescription(update.getDescription());
        category.setCreate_at(update.getCreatedAt());
        category.setStatus(update.isStatus());
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findbyId(id);
        if(category==null){
            try{
                throw new ChangeSetPersister.NotFoundException();
            }catch (ChangeSetPersister.NotFoundException e){
                throw new RuntimeException();
            }
        }
        category.setStatus(false);
        categoryRepository.save(category);




    }
}
