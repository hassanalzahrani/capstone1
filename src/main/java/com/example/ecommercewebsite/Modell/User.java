package com.example.ecommercewebsite.Modell;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "ID should not be empty")
    private int id;
    @NotEmpty(message = "password should not be empty")
    @Min(value = 7,message = "password have to be more than 6 length long")

   private String username;
   private String password;
   private String email;
    @Pattern(regexp = "^(supervisor|coordinator)$")
   private String role;
    @NotNull(message = "balance should not be empty")
    @Positive(message = "balance should be positive")
   private int balance;



}
