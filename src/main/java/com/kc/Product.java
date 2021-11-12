package com.kc;

public class Product {
    public Product(Integer productId, Integer productQty, Double productPrice) {
        this.productId = productId;
        this.productQty = productQty;
        this.productPrice = productPrice;
    }
    Integer productId;
    Integer productQty;
    Double productPrice;

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public Integer getProductId() {
        return productId;
    }

}
