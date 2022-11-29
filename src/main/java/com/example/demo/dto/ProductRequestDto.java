package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductRequestDto {

    @NotEmpty
    @NotBlank(message = "Product name must be written")
    private String product_name;

    @NotNull(message = "Product price must be written")
    private int price;

    @NotEmpty @NotBlank
    private boolean available;
}
