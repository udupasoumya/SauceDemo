package com.saucedemo.pageobjects;

import com.saucedemo.enums.Products;
import com.saucedemo.utilities.CommonUtils;
import com.saucedemo.utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends CommonUtils {

    WebDriver driver;
    WebDriverWait wait;


    private final By itemName= By.className( "inventory_item_name");
    private final By removeItem= By.className("remove-from-cart-button");
    private final By itemQuantity = By.className("cart_quantity");

    public void verifyOnCartPage(){
        String url = getCurrentURL();
        if (!url.contains("cart")){
            throw new TestException("ERROR: Not on SHOPPING_CART_PAGE! URL: " + url);
        }
    }

    public void verifyProductTitle(String title){
        List<WebElement> prdTitle =getElements(itemName);
        boolean isValid=false;
        String actualTitle="";
        for(WebElement validTitle: prdTitle) {
            actualTitle = validTitle.getText();
            if (title.equals(actualTitle)) {
                isValid = true;
                break;
            }
        }
            if(!isValid){
                throw new TestException("ERROR: PRODUCT_PAGE: Product Title is ['" + actualTitle + "']. Expected ['" + title + "'].");
            }
        }



    public String getProductTitle(By elem){
        return getElementText(elem);
    }

    public String getProductQuantity(){
        return getElementText(itemQuantity);
    }

    public void verifyCartQuantity(String quantity){
        String actualQuantity= getProductQuantity();
        if(!quantity.equals(actualQuantity)){
            throw new TestException("Error Product Quanity is different");

        }
    }


}
