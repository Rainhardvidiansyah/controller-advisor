package com.example.demo.entity;

import com.example.demo.dto.ProductRequestDto;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class Product {

    private String id;

    private String product_name;

    private int price;

    private boolean available;

    public static Product saveFrom(ProductRequestDto productRequestDto){
        var product = new Product();
        product.setProduct_name(product.getProduct_name());
        product.setPrice(product.getPrice());
        return product;
    }
}
