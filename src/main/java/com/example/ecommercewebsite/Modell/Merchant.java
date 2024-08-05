package com.example.ecommercewebsite.Modell;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Merchant {
    @NotNull(message = "ID should not be empty")
    private int id;

    @Size(min = 4,max = 30,message = "Category name must be more than 3 characters")
    @NotEmpty(message = "Category name should not be empty")
    private String name;
}
