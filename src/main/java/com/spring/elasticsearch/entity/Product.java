package com.spring.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "cluster-products")
public class Product {

    @Id
    private Long id;
    @Field(type = FieldType.Text, name = "name")
    private String name;
    @Field(type = FieldType.Text, name = "category")
    private String category;
    @Field(type = FieldType.Integer, name = "quality")
    private Integer quality;
    @Field(type = FieldType.Double, name = "price")
    private Double price;
}
