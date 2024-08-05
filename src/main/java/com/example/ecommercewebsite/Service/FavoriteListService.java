package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.FavoriteList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteListService {
    private final List<FavoriteList> favoriteLists = new ArrayList<>();
    public void addFavorite(FavoriteList favoriteList) {
        favoriteLists.add(favoriteList);
    }

    public boolean removeFavorite(int userId, int productId) {
        return favoriteLists.removeIf(fav -> fav.getUserId() == userId && fav.getProductId() == productId);
    }

    public List<FavoriteList> getFavoritesByUserId(int userId) {
        List<FavoriteList> userFavorites = new ArrayList<>();
        for (FavoriteList fav : favoriteLists) {
            if (fav.getUserId() == userId) {
                userFavorites.add(fav);
            }
        }
        return userFavorites;
    }
}
