package com.example.ecommercewebsite.Modell;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteList {
    @NotNull(message = "ID should not be empty")
    private int id;
    
    @NotNull(message = "user ID should not be empty")
    private int userId;
    
    @NotNull(message = "product ID should not be empty")
    private int productId;
}
