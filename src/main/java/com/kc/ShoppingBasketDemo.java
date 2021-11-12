package com.kc;

import java.util.*;

public class ShoppingBasketDemo {

    public static void main(String[] args) {

        //create promotions
        PromotionalRules promotionalRules = new PromotionalRules();
        Map percentageDiscountToThresholdValue = new HashMap<Integer, Double>();
        percentageDiscountToThresholdValue.put(75,0.1);
        promotionalRules.setPercentageDiscountToThresholdValue(percentageDiscountToThresholdValue);

        PromotionalRules.ProductDiscount productDiscount = new PromotionalRules.ProductDiscount();
        productDiscount.setDiscountedAmount(22.99);
        productDiscount.setProductId(1);
        productDiscount.setQtyRequiredForDiscount(2);
        Set<PromotionalRules.ProductDiscount> productDiscounts = new HashSet<>();
        productDiscounts.add(productDiscount);
        promotionalRules.setProductDiscounts(productDiscounts);

        // create basket with products and set promotions
        Basket basket = new Basket(promotionalRules);
        Product waterBottle = new Product(1, 2, 24.95);
        basket.addProduct(waterBottle);
        Product hoodie = new Product(2, 1, 65.00);
        basket.addProduct(hoodie);
        Product stickerSet = new Product(3, 1, 3.99);
        basket.addProduct(stickerSet);

        // apply the promotions to the basket
        basket.applyPromotions();
    }

}
