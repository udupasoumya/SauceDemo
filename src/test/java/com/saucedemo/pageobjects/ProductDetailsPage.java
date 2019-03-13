package com.saucedemo.pageobjects;

import com.saucedemo.enums.Products;
import com.saucedemo.enums.URL;
import com.saucedemo.utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class ProductDetailsPage extends CommonUtils {

    private final By prdTitle= By.cssSelector(".inventory_details_name");
    private final By addToCart=By.cssSelector(".add-to-cart-button");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");

    public void verifyOnProductDetailsPage(){
        String url= getCurrentURL();
        if(!url.contains("inventory-item.html"))
            throw new TestException("Error not on Product Details Page");
    }


    public void navigateToProductPage(Products product){
        String url = URL.BASEURL.getUrl() + URL.PRODUCT_PAGE.getUrl() + product.getProductId();
        navigateToURL(url);
        System.out.println("PRODUCT_PAGE: Navigated to " + url);
    }

    public void verifyProductTitle(String title){
        String actualTitle = getProductTitle();
        if (!title.equals(actualTitle)){
            throw new TestException("ERROR: PRODUCT_PAGE: Product Title is ['" + actualTitle + "']. Expected ['" + title + "'].");
        }
    }

    public String getProductTitle(){
        return getElementText(prdTitle);
    }

    public void AddToCart(){
        waitForElementToBeClickable(addToCart);
        click(addToCart);
    }

    public void navigateToCart(){
        waitForElementToBeClickable(cartBadge);
        click(cartBadge);
    }



}
