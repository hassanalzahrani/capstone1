package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
 ArrayList<Category> categories = new ArrayList<Category>();

 public ArrayList<Category> getCategories() {
     return categories;
 }
 public void addCategory(Category category) {
     categories.add(category);

 }
 public boolean updateCategory(int id, Category category) {
     for (int i = 0; i < categories.size(); i++) {
         if (categories.get(i).getId() == id) {
             categories.get(i).setName(category.getName());
             return true;
         }
     }
     return false;
 }
public boolean deleteCategory(int id) {
     for (int i = 0; i < categories.size(); i++) {
         if (categories.get(i).getId() == id) {
             categories.remove(i);
             return true;
         }
     }
     return false;

}



}
