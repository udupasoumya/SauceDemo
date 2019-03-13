package com.saucedemo.actions;

import com.saucedemo.pageobjects.HomePage;
import com.saucedemo.pageobjects.ProductListingPage;
import com.saucedemo.utilities.ReadConfig;
import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.io.IOException;

public class LoginAction {
    ReadConfig read;


    public void loginAction() throws IOException {
        read= new ReadConfig();
        HomePage homePage=new HomePage();
        ProductListingPage prdListPage= new ProductListingPage();
        homePage.navigateToLoginPage();
        homePage.setUserName(read.returnConfigdata("userName"));
        homePage.setPassword(read.returnConfigdata("password"));
        homePage.submitLogin();
        prdListPage.validateOnProductListingPage();
    }


}
