package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.MerchantStock;
import com.example.ecommercewebsite.Modell.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;
    ArrayList<MerchantStock> merchantStocks = new ArrayList<MerchantStock>();

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;

    }

    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);

    }

    public boolean updateMerchantStock(int id, MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public int addToMerchantStock(int productId, int merchid, int amount) {
        for (MerchantStock merchantStock : merchantStocks) {
            if (merchantStock.getMerchantid() == merchid) {
                if (merchantStock.getProductid() == productId) {

                    merchantStock.setStock(merchantStock.getStock() + amount);
return 10;
                }return -2;


            }return -1;


        }
        return 0;
    }
}

