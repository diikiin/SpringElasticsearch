package com.spring.elasticsearch.controller;

import com.spring.elasticsearch.entity.Product;
import com.spring.elasticsearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<Product> getAll(PageRequest pageRequest) {
        return productService.getAll(pageRequest);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public void create(Product product) {
        productService.create(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, Product product) {
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
