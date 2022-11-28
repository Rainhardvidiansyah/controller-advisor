package com.example.demo.service;

import com.example.demo.dto.ProductRequestDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProductService implements ProductRepository {


    @Override
    public Product saveProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        product.setAvailable(true);
        product.setProduct_name(product.getProduct_name());
        product.setPrice(product.getPrice());
        log.info("New Data: {}", product);
        return product;
    }

    @Override
    public List<Product> findAllProduct() {
        return null;
    }

    @Override
    public Optional<Product> findProductName(String productName) {
        var product = new Product();
        return Optional.ofNullable(product);
    }
}
