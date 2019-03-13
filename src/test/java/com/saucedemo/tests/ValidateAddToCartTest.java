package com.saucedemo.tests;

import com.aventstack.extentreports.Status;
import com.saucedemo.actions.ProductOrderActions;
import com.saucedemo.enums.Products;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidateAddToCartTest extends BaseTest {
    ProductOrderActions prdOrderAction;

    @Test
    public void test_AddToCart() throws IOException {
        logger=extent.createTest("To Verify Add To Cart in Sauce");
        Products bikeLight =Products.BIKE_LIGHT;
        Products prdOnesis =Products.LAB_ONESIS;
        List<Products> prodList = new ArrayList<Products>();
        prodList.add(bikeLight);
        prodList.add(prdOnesis);
        prdOrderAction = new ProductOrderActions();
        logger.log(Status.INFO, "Navigate to Login Page");
        prdOrderAction.gotoLoginPageAction();
        prdOrderAction.loginAction();
        logger.log(Status.INFO, "Logged in to Sauce Site");
        for(Products prd: prodList) {
            logger.log(Status.INFO, "Navigated to Product Details page for: "+prd.getProducttitle());
            prdOrderAction.productDetailsAction(prd);
            logger.log(Status.INFO, "Added "+ prd.getProducttitle()+ " to Cart");
            prdOrderAction.addToCartAction(prd);
            logger.log(Status.INFO, "Validate product "+prd.getProducttitle()+" in Cart Details");
            prdOrderAction.validateCartAction(prd);
        }

    }




}
