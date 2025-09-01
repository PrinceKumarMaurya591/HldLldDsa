package com.conceptcoding.behavioralpatterns.state.context;

enum ProductType {
    CHOCOLATE,
    CHIPS,
    SOFT_DRINKS
}

public class Product {
    ProductType type;
    String name;
    String productCode;
    Double price;
    int quantity;

    public Product(ProductType type, String name, String productCode, Double price, int quantity) {
        this.type = type;
        this.name = name;
        this.productCode = productCode;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [type=" + type + ", name=" + name +
                ", productCode=" + productCode + ", price=" + price +
                ", quantity: " + quantity +
                "]";
    }
}
