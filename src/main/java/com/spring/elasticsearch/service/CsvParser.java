package com.spring.elasticsearch.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.spring.elasticsearch.entity.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvParser {

    public List<Product> parse(String path) {
        List<Product> productList = new ArrayList<>();

        try {
            Resource resource = new ClassPathResource(path);
            InputStreamReader isr = new InputStreamReader(resource.getInputStream());
            CSVReader csvReader = new CSVReader(isr);
            csvReader.readNext();

            String[] row;
            while ((row = csvReader.readNext()) != null) {
                Long id = Long.parseLong(row[0]);
                String name = row[1];
                String description = row[2];
                Integer quality = Integer.parseInt(row[3]);
                Double price = Double.parseDouble(row[4]);

                productList.add(new Product(id, name, description, quality, price));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }
}
