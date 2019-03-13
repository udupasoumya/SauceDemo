package com.saucedemo.enums;

public enum Products {

    BIKE_LIGHT(0, "Sauce Labs Bike Light","1"),
    LAB_ONESIS(2,"Sauce Labs Onesie","1");

    private int id;
    private String producttitle;
    private String quantity;

    Products(int id, String producttitle, String quantity){
        this.id=id;
        this.producttitle=producttitle;
        this.quantity=quantity;

    }

    public String getProducttitle(){
        return  producttitle;

    }

    public int getProductId(){
        return  id;

    }

    public String getQuantity(){
        return quantity;
    }



}
