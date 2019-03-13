package com.saucedemo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class DriverUtils {
    public static WebDriver driver;
    public static ReadConfig read;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
       // read= new ReadConfig();
        System.setProperty("webdriver.chrome.driver", read.returnConfigdata("chromepath"));
       // driver = new ChromeDriver();
    }

    public static  WebDriver getDriver() throws IOException {
        if ( driver == null) {
            read = new ReadConfig();
            System.setProperty("webdriver.chrome.driver", read.returnConfigdata("chromepath"));
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }



}
