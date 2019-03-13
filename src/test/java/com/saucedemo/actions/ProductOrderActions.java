package com.saucedemo.actions;

import com.saucedemo.enums.Products;
import com.saucedemo.pageobjects.CartPage;
import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.ProductDetailsPage;
import com.saucedemo.pageobjects.ProductListingPage;
import com.saucedemo.utilities.ReadConfig;

import java.io.IOException;

public class ProductOrderActions {

    ReadConfig read;

    public ProductOrderActions() throws IOException {
        read = new ReadConfig();
    }


    public void gotoLoginPageAction() throws IOException {
        HomePage homePage=new HomePage();
        homePage.navigateToLoginPage();
    }


    public void loginAction() throws IOException {
        HomePage homePage=new HomePage();
        ProductListingPage prdListPage= new ProductListingPage();
        homePage.setUserName(read.returnConfigdata("userName"));
        homePage.setPassword(read.returnConfigdata("password"));
        homePage.submitLogin();
        prdListPage.validateOnProductListingPage();
    }

    public void productDetailsAction(Products product) {
        System.out.println("Staring process to load info for " + product);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.navigateToProductPage(product);
        productDetailsPage.verifyOnProductDetailsPage();
        productDetailsPage.verifyProductTitle(product.getProducttitle());
    }

    public void addToCartAction(Products product){
        System.out.println("Adding " + product + " to cart:");
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.navigateToProductPage(product);
        productDetailsPage.AddToCart();
        productDetailsPage.navigateToCart();
        CartPage cart = new CartPage();
        cart.verifyOnCartPage();
    }

    public void validateCartAction(Products product){
        CartPage cart = new CartPage();
        cart.verifyProductTitle(product.getProducttitle());
        cart.verifyCartQuantity(product.getQuantity());
    }
}
