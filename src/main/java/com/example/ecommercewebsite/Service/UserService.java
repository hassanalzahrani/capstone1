package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.MerchantStock;
import com.example.ecommercewebsite.Modell.Product;
import com.example.ecommercewebsite.Modell.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor
public class UserService {

    ProductService productService;

    ArrayList<User> users = new ArrayList<User>();

    public void addUser(User user) {
        users.add(user);

    }

    public boolean updateUser(int id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }


}









