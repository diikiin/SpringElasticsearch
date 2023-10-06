package com.spring.elasticsearch.repository;

import com.spring.elasticsearch.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    Page<Product> findByName(String name, Pageable pageable);

    Page<Product> findByCategory(String category, Pageable pageable);

    Page<Product> findByPriceIsLessThanEqual(Double price, Pageable pageable);

    Page<Product> findByPriceIsGreaterThanEqual(Double price, Pageable pageable);
}
