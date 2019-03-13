# SauceDemo

Framework to test the https://www.saucedemo.com 

Dependencies:
1. Maven set up to import all dependencies
2. TestNG is used along with Selenium to handle Test and the UI components
3. Extent Reports is used for custom reporting

Framework:
1. Configuration: Config.properties--> has details on the user to login and the details on chromedriver path
2. Drivers: has the chrome driver
3. Reports: test-output--> ResultsExtentReport.html : The report generated based on TestNG Listners and the Log
4. test:java:com:saucedemo: actions: Logical Grouping of certain actions like Login Actions, Product Details page actions, Add To Cart action
5. test:java:com:saucedemo: enums: Used Enums to define the data for URL's and Products to be used in testing(can use a external data file for this as well)
6. test:java:com:saucedemo: pageobjects: Capturing all page objects for Login, Product Details page, Cart etc
7. test:java:com:saucedemo: tests: Actual Test
8. Utilities: ReadConfig: To read the config data from config.properties
9. Utilities: CommonUtils: Wrapper around existing selenium methods like getText, getPageTitle etc
10. Utilities: DriverUtils: Set up for Driver and get Driver
11. Utilities: ListnerTestNG: implements the ITestListener and has override for methos: OnSuccess, OnFailure, OnStart etc

Instruction To Run:
Get the code on to local and you should be able to run the TestNG.xml
Report will be updated into  Reports: test-output--> ResultsExtentReport.html

