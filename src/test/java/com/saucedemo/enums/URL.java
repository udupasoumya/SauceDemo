package com.saucedemo.enums;

public enum URL {
    BASEURL("https://www.saucedemo.com"),
    PRODUCT_PAGE("/inventory-item.html?id=");

    String url;

    URL(String url){
        this.url=url;
    }

    public String getUrl(){
        return url;
    }

}
