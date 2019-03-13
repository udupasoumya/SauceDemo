package com.saucedemo.actions;

import com.saucedemo.enums.Products;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.ProductDetailsPage;
import com.saucedemo.pageobjects.ProductListingPage;


public class ProductDetailsPageAction {

    public void productDetailsAction(Products product) {
        System.out.println("Staring process to load info for " + product);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.navigateToProductPage(product);
        productDetailsPage.verifyOnProductDetailsPage();
        productDetailsPage.verifyProductTitle(product.getProducttitle());
        productDetailsPage.AddToCart();
        productDetailsPage.navigateToCart();
    }

}
