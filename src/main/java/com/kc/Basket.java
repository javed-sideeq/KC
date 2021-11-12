package com.kc;

import java.util.HashSet;
import java.util.Set;

public class Basket {
    public Set<Product> getProducts() {
        return products;
    }

    Set<Product> products; //We don't want duplicate products, so we use set, the quantity should be updated instead
    // and override the equals and hashCode methods to ensure proper use in collections
    PromotionalRules promotionalRules;

    public Double getBasketTotal() {
        return basketTotal;
    }

    Double basketTotal;
    public Basket(PromotionalRules promotionalRules) {
        this.promotionalRules = promotionalRules;
        this.products = new HashSet<>();
        this.basketTotal = 0.0;
    }
    public void addProduct(Product product) {
        products.add(product);
        basketTotal = basketTotal + product.getProductPrice();
    }

    public void applyPromotions() {
        promotionalRules.getProductDiscounts().stream().forEach((d) -> {
            Integer productId = d.getProductId();
            Integer qtyThreshold = d.getQtyRequiredForDiscount();
            Double discountedAmount = d.getDiscountedAmount();
            products.stream().filter(p-> p.getProductId().equals(productId) && p.getProductQty().equals(qtyThreshold))
                    .forEach(product -> product.setProductPrice(discountedAmount));
        });

        Integer thresholdAmount = (Integer) promotionalRules.getPercentageDiscountToThresholdValue().keySet().toArray()[0];
        Double percentageDiscount = (Double) promotionalRules.getPercentageDiscountToThresholdValue().values().toArray()[0];

        if(basketTotal > thresholdAmount) {
            basketTotal = basketTotal - (basketTotal * percentageDiscount);
        }

    }
}
