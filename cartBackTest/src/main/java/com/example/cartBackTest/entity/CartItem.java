package com.example.cartBackTest.entity;

public class CartItem {
    private Long id; // 購物車項目 ID
    private Long productId; // 商品 ID
    private String productName; // 商品名稱
    private Double price; // 商品價格
    private Integer quantity; // 商品數量
    private Double totalPrice; // 總價

    // 預設建構子
    public CartItem() {
    }

    // 全參數建構子
    public CartItem(Long id, Long productId, String productName, Double price, Integer quantity, Double totalPrice) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters 和 Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // 總價計算方法
    public void calculateTotalPrice() {
        this.totalPrice = this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}