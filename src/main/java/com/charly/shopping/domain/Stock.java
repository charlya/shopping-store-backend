package com.charly.shopping.domain;

public class Stock {

    private String shopName;
    private int avaible;

    public Stock(String shopName, int avaible) {
        this.shopName = shopName;
        this.avaible = avaible;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getAvaible() {
        return avaible;
    }

    public void setAvaible(int avaible) {
        this.avaible = avaible;
    }
}
