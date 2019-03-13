package com.saucedemo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.utilities.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    public ExtentTest logger;
    public ExtentReports extent;
    public ExtentHtmlReporter htmlReporter;

    @BeforeClass
    public void setReportLogging() throws IOException {
        htmlReporter = new ExtentHtmlReporter("./Reports/test-output/ResultsExtentReport.html");
        htmlReporter.loadXMLConfig("./extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "SauceDemo");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "QA");        htmlReporter.config().setDocumentTitle("Test Report for Sauce Demo");
        // Name of the report
        htmlReporter.config().setReportName("Test Report");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }

    @BeforeMethod
    public void setUp() throws IOException {
        driver= DriverUtils.getDriver();

    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
       extent.flush();
    }




}
