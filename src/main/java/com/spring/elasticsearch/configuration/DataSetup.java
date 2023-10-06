package com.spring.elasticsearch.configuration;

import com.spring.elasticsearch.entity.Product;
import com.spring.elasticsearch.repository.ProductRepository;
import com.spring.elasticsearch.service.CsvParser;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSetup {

    private final ProductRepository productRepository;
    private final CsvParser csvParser;

    @PostConstruct
    public void dataSetup() {
        List<Product> products = csvParser.parse("products.csv");
        productRepository.saveAll(products);
    }
}
