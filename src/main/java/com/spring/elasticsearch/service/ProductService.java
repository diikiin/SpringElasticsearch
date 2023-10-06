package com.spring.elasticsearch.service;

import com.spring.elasticsearch.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> getAll(Pageable pageable);

    Product getById(Long id);

    void create(Product product);

    void update(Long id, Product product);

    void delete(Long id);

    Page<Product> getByName(String name, Pageable pageable);

    Page<Product> getByCategory(String category, Pageable pageable);

    Page<Product> getByPriceIsLessThan(Double price, Pageable pageable);

    Page<Product> getByPriceIsGreaterThan(Double price, Pageable pageable);

}
