package com.saucedemo.pageobjects;

import com.saucedemo.enums.URL;
import com.saucedemo.utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends CommonUtils {


    private final By userName= By.id("user-name");
    private final By passWrd= By.id("password");
    private final By btnLogin= By.xpath("//input[@type='submit']");

    public void navigateToLoginPage(){
        String url= URL.BASEURL.getUrl();
        navigateToURL(url);
    }


    public void setUserName(String uname){
       waitForElementToBeVisible(userName);
       sendKeys(userName,uname);

    }

    public void setPassword(String password){
        waitForElementToBeVisible(passWrd);
        sendKeys(passWrd,password);

    }

    public void submitLogin(){
        waitForElementToBeClickable(btnLogin);
        click(btnLogin);
    }


}
