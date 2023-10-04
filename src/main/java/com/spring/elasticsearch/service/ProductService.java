package com.spring.elasticsearch.service;

import com.spring.elasticsearch.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {

    Page<Product> getAll(PageRequest pageRequest);

    Product getById(Long id);

    void create(Product product);

    void update(Long id, Product product);

    void delete(Long id);

}
