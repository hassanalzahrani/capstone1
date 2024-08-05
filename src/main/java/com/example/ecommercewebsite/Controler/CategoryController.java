package com.example.ecommercewebsite.Controler;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Modell.Category;
import com.example.ecommercewebsite.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {


    private final CategoryService categoryService;


    @GetMapping("/get")
    public ResponseEntity getCategory() {
        ArrayList<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);

        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("category added successfully"));
    }
  @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable int id, @Valid @RequestBody Category category, Errors errors) {
      if (errors.hasErrors()) {
          String message = errors.getFieldError().getDefaultMessage();
          return ResponseEntity.badRequest().body(message);

      }
      boolean isupdated = categoryService.updateCategory(id, category);
      if (isupdated) {
          return ResponseEntity.status(200).body(new ApiResponse("category updated successfully"));
      }
      return ResponseEntity.status(404).body(new ApiResponse("category not found"));

  }
  @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id) {
            boolean isdeleted = categoryService.deleteCategory(id);
            if (isdeleted) {
                return ResponseEntity.status(200).body(new ApiResponse("category deleted successfully"));
            }
            return ResponseEntity.status(404).body(new ApiResponse("category not found"));
  }
}
