package com.example.ecommercewebsite.Modell;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MerchantStock {
   @NotNull(message = "id should not be empty")
   private int id;
   @NotNull(message = "productid should not be empty")
   private int productid ;
   @NotNull(message = "merchantid should not be empty")
   private int merchantid ;
   @NotNull(message = "productid should not be empty")
@Min(value = 11,message = "the stock must be more than 10")
   private int stock;



}
