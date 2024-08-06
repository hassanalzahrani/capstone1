package com.example.ecommercewebsite.Controler;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Modell.MerchantStock;
import com.example.ecommercewebsite.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchantStock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping("get")
    public ResponseEntity getMerchantStock() {

        return ResponseEntity.ok(merchantStockService.getMerchantStocks());
    }

    @PostMapping("add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {

            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("merchant stock added successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id, @Valid @RequestBody MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        boolean isupdated = merchantStockService.updateMerchantStock(id, merchantStock);
        if (isupdated) {
            return ResponseEntity.ok(new ApiResponse("merchant stock updated successfully"));

        }
        return ResponseEntity.status(404).body(new ApiResponse("merchant stock not found"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMerchantStock(@RequestParam int id) {
        merchantStockService.deleteMerchantStock(id);
        return ResponseEntity.ok(new ApiResponse("merchant stock deleted successfully"));
    }

    @PostMapping("add/{productid}/{merchid}/{amount}")
    public ResponseEntity addToMerchantStock(@PathVariable int productId, @PathVariable int merchid, @PathVariable int amount) {

        if (merchantStockService.addToMerchantStock(productId, merchid, amount) == 0){
            return ResponseEntity.status(400).body(new ApiResponse("out stock"));}

        if (merchantStockService.addToMerchantStock(productId, merchid, amount) == -1){
            return ResponseEntity.status(400).body(new ApiResponse("merchantId not found"));}
        if (merchantStockService.addToMerchantStock(productId, merchid, amount) == -2) {
            return ResponseEntity.status(400).body(new ApiResponse("product ID not found"));

        }

if (merchantStockService.addToMerchantStock(productId, merchid, amount) == 10) {
    return ResponseEntity.status(200).body(new ApiResponse("product added successfully"));
}
return null;
    }
}

