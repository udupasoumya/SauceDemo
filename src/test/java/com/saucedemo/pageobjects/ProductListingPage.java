package com.saucedemo.pageobjects;

import com.saucedemo.utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestException;

public class ProductListingPage extends CommonUtils {

    private final By prdLabel= By.cssSelector(".product_label");

    public void validateOnProductListingPage(){
        waitForElementToBeVisible(prdLabel);
        String url= getCurrentURL();
        if(!url.contains("/inventory.html"))
            throw new TestException("Error- not on product listing page");
    }



}
