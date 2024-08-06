package com.example.ecommercewebsite.Controler;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Modell.Merchant;
import com.example.ecommercewebsite.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant() {
        ArrayList<Merchant> merchants = merchantService.getMerchants();
        return ResponseEntity.ok(merchants);

    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors) {
        if (errors.hasErrors()) {
           String message = errors.getFieldError().getDefaultMessage();
           return ResponseEntity.badRequest().body(message);

        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @Valid @RequestBody Merchant merchant,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);

        }
     boolean isUpdated = merchantService.updateMerchant(id, merchant);
        if (isUpdated) {
                return ResponseEntity.status(200).body(new ApiResponse("Merchant updated successfully"));

        }
        return ResponseEntity.status(404).body(new ApiResponse("Merchant not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id) {
        boolean isdeleted = merchantService.deleteMerchant(id);
        if (isdeleted) {
            return ResponseEntity.ok(new ApiResponse("Merchant deleted successfully"));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Merchant not found"));
    }
}
