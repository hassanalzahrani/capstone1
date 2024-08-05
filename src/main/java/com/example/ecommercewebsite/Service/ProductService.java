package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.MerchantStock;
import com.example.ecommercewebsite.Modell.Product;
import com.example.ecommercewebsite.Modell.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
    ArrayList<Product> products = new ArrayList<Product>();
    private final UserService userService;
    private final MerchantStockService merchantStockService;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean updateProduct(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return true;
            }
        }
        return false;

    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

//======================================

    public int userBuyProduct(int productId, int userId, int merchantId) {


        for (MerchantStock m : merchantStockService.merchantStocks) {
            if (merchantId == m.getMerchantid()) {
                if (productId == m.getProductid()) {
                    for (User u : userService.users) {
                        if (u.getId() == userId) {
                            if (m.getStock() > 0) {
                                for (Product p : products) {
                                    if (p.getId() == productId) {
                                        if (u.getBalance() >= p.getPrice()) {
                                            m.setStock(m.getStock() - 1);
                                            u.setBalance(u.getBalance() - p.getPrice());
                                        }
                                        return 4;
                                    }

                                }
                            }
                            return 3;

                        }
                        return 2;
                    }
                }
                return 1;
            }
            return 0;
        }
        return 10;
    }


    public boolean applyDiscount(int productId, double discountPercentage) {
        for (Product p : products) {
            if (p.getId() == productId) {
                if (discountPercentage > 0 && discountPercentage <= 100) {
                    int originalPrice = p.getPrice();
                    int discountAmount = (int) (originalPrice * (discountPercentage / 100.0));
                    p.setPrice(originalPrice - discountAmount);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}

