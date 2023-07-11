package com.tuananh.manager.services.impl;

import com.tuananh.manager.dto.request.ProductRequest;
import com.tuananh.manager.model.Product;
import com.tuananh.manager.repositories.ProductRepository;
import com.tuananh.manager.services.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductService  productService;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCreate_at(request.getCreatedAt());
        product.setDiscount_id(request.getDiscount_id());
        product.setStatus(true);
        productRepository.save(product);

    }

    @Override
    public void update(ProductRequest request, Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product==null){
            try{
                throw new ChangeSetPersister.NotFoundException();
            }catch (ChangeSetPersister.NotFoundException e){
                throw new RuntimeException();
            }
        }
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCreate_at(request.getCreatedAt());
        product.setDiscount_id(request.getDiscount_id());

    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product==null){
            try{
                throw new ChangeSetPersister.NotFoundException();
            }catch (ChangeSetPersister.NotFoundException e){
                throw new RuntimeException();
            }
        }
        product.setStatus(false);
        productRepository.save(product);

    }
}
