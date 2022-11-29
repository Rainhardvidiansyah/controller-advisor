package com.example.demo.controller;


import com.example.demo.dto.ProductRequestDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save-data")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductRequestDto productDto){
        Product product = productService.createProduct(Product.saveFrom(productDto));
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }




}


/*
    @GetMapping("/data")
    @ResponseBody
    public ResponseEntity<?> fizz(@RequestParam String point){
        boolean check = validatePoint(point);
        if(check){
            return new ResponseEntity<>("Not true", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(point + " buzz", HttpStatus.OK);
    }

    private static boolean validatePoint(String point){
        return !point.equalsIgnoreCase("fizz");
    }
 */