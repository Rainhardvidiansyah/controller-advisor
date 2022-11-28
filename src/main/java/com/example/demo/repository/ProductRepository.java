package com.example.demo.repository;

import com.example.demo.entity.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    public Product saveProduct(Product product);

    public List<Product> findAllProduct();

    public Optional<Product> findProductName(String productName);

}
