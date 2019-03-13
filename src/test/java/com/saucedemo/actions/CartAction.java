package com.saucedemo.actions;

import com.saucedemo.enums.Products;
import com.saucedemo.pageobjects.CartPage;

public class CartAction {

    public void validateCartAction(Products product){
        CartPage cart = new CartPage();
        cart.verifyOnCartPage();
        cart.verifyProductTitle(product.getProducttitle());
        cart.verifyCartQuantity(product.getQuantity());
    }

}
