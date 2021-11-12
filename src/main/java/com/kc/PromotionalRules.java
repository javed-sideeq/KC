package com.kc;

import java.util.Map;
import java.util.Set;

public class PromotionalRules {

    Map<Integer, Integer> percentageDiscountToThresholdValue;
    Set<ProductDiscount> productDiscounts;

    public Map<Integer, Integer> getPercentageDiscountToThresholdValue() {
        return percentageDiscountToThresholdValue;
    }

    public void setPercentageDiscountToThresholdValue(Map<Integer, Integer> percentageDiscountToThresholdValue) {
        this.percentageDiscountToThresholdValue = percentageDiscountToThresholdValue;
    }

    public Set<ProductDiscount> getProductDiscounts() {
        return productDiscounts;
    }

    public void setProductDiscounts(Set<ProductDiscount> productDiscounts) {
        this.productDiscounts = productDiscounts;
    }

    public static class ProductDiscount {
        Integer productId;
        Integer qtyRequiredForDiscount;
        Double discountedAmount;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getQtyRequiredForDiscount() {
            return qtyRequiredForDiscount;
        }

        public void setQtyRequiredForDiscount(Integer qtyRequiredForDiscount) {
            this.qtyRequiredForDiscount = qtyRequiredForDiscount;
        }

        public Double getDiscountedAmount() {
            return discountedAmount;
        }

        public void setDiscountedAmount(Double discountAmount) {
            this.discountedAmount = discountAmount;
        }
    }
}
