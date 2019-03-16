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


How to Run(on local with Maven)

1. The pom.xml has the details on the TestNG suite
2. On local make sure you clone the repository
3. Navigate to the directory for the repo on local on cmd line
4. Make sure maven is installed: mvn --version should give u the details on the maven version installed as well as the java jdk version. Make note of the jdk version(example below) 
mvn --version 
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T11:41:47-07:00) Maven home: /Users/soumya/Documents/apache-maven-3.6.0 
Java version: 11.0.2, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home Default locale: en_US, platform encoding: UTF-8 OS name: "mac os x", version: "10.13.6", arch: "x86_64", family: "mac"
5. For the above the jdk is 11
6. Update the pom.xml within the project to show the correct jdk version for the maven compiler plugin 
`<plugin> <groupId>org.apache.maven.plugins</groupId> <artifactId>maven-compiler-plugin</artifactId> <version>3.7.0</version> <configuration> <release>11</release> </configuration> </plugin>`
7. Make sure that release above(within configurations) matches with the jdk on your system(as in the above case its 11)
8. Save and close pom.xml
9. Now from cmd line within the project folder type >> mvn clean test
This will run the test on local
