package com.example.ecommercewebsite.Modell;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
@NotNull(message = "ID Product should not be empty")
    private int id;
@NotEmpty(message = "Product name should not be empty")
@Size(min = 4,max = 30,message = "Product Name must be more than 3 characters")
        private String Name;
@Positive(message = "Product Price must be Positive  ")
        private int Price;
@NotEmpty(message = "Category ID should not be empty")
        private String categoryID;

}
