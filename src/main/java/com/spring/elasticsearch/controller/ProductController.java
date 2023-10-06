package com.spring.elasticsearch.controller;

import com.spring.elasticsearch.entity.Product;
import com.spring.elasticsearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<Product> getAll(Pageable pageable) {
        return productService.getAll(pageable);
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

    @GetMapping("/{name}")
    public Page<Product> getByName(@PathVariable("name") String name, Pageable pageable) {
        return productService.getByName(name, pageable);
    }

    @GetMapping("/category")
    public Page<Product> getByCategory(@RequestParam("category") String category, Pageable pageable) {
        return productService.getByCategory(category, pageable);
    }

    @GetMapping("/price/less/{price}")
    public Page<Product> getByPriceIsLessThan(@PathVariable("price") Double price, Pageable pageable) {
        return productService.getByPriceIsLessThan(price, pageable);
    }

    @GetMapping("/price/greater/{price}")
    public Page<Product> getByPriceIsGreaterThan(@PathVariable("price") Double price, Pageable pageable) {
        return productService.getByPriceIsGreaterThan(price, pageable);
    }
}
