package com.spring.elasticsearch.service;

import com.spring.elasticsearch.entity.Product;
import com.spring.elasticsearch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow();
    }

    @Override
    @Transactional
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void update(Long id, Product product) {
        Product entity = productRepository.findById(id)
                .orElseThrow();

        entity.setName(product.getName());
        entity.setCategory(product.getCategory());
        entity.setQuality(product.getQuality());
        entity.setPrice(product.getPrice());

        productRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> getByName(String name, Pageable pageable) {
        return productRepository.findByName(name, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> getByCategory(String category, Pageable pageable) {
        return productRepository.findByCategory(category, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> getByPriceIsLessThan(Double price, Pageable pageable) {
        return productRepository.findByPriceIsLessThanEqual(price, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> getByPriceIsGreaterThan(Double price, Pageable pageable) {
        return productRepository.findByPriceIsGreaterThanEqual(price, pageable);
    }
}
