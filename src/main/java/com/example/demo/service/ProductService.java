package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.NoProductException;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductId(Long id){
        return productRepository.findById(id).orElseThrow((NoProductException::new));
    }

}
