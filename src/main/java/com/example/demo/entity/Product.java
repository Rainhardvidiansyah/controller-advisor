package com.example.demo.entity;

import com.example.demo.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "tbl_product")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product_name;

    private int price;

    private boolean available;

    public static Product saveFrom(ProductRequestDto productRequestDto){
        var product = new Product();
        product.setProduct_name(product.getProduct_name());
        product.setPrice(product.getPrice());
        product.setAvailable(productRequestDto.isAvailable());
        return product;
    }
}
