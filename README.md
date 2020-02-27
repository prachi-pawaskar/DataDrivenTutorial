# Data Driven Automation Framework Tutorial

The project demonstrates use of Data driven automation framework.
The framework implements one test case for showcase purpose.

## About Data driven framework

Data driven approach is to used to run a single test case against multiple set of data.


## Getting Started

These instructions will help you get started.

### Prerequisites

1. Java
2. Maven
3. Browser driver [Project have a chrome driver embedded, chrome version: Version 76.0.3809.100 (64-bit)]

## About this project

There are multiple approaches to implement data driven, and the project tries to demonstrate all the methods possible.
Following are the types and testng file mapped:
* testng_WithoutExternalData.xml >> Where credentials are hard coded in the test.
* testng_HardCodedTestngParams.xml >> Where TestNg @Parameters are used. Here credentials are passed through testng xml file.
* testng_HardCodedDataProvider.xml >> Where @DataProvider is used. Here credentials are hard coded in the data provider itself. 
* testng_ExcelDataProvider.xml >> Credentials are picked from external excel file. @DataProvider is used to supply data to the @Test.
* testng_CsvDataProvider.xml >> Credentials are picked from external CSV file. @DataProvider is used to supply data to the @Test. Here we can active or inactive any of the test data.

## Tests

Uses [Zero banking site](http://zero.webappsecurity.com/index.html) for scenarios.

### Test scenarios

1. Login to the portal successfully and verify landing page.
2. Multiple credentials are used to implement the data driven project.
3. Correct credentials are: username/password

### How to execute test

Right click on any of the respective TestNG xml file and run as testng suite.

### Reports

Default testng reports are generated under /test-output folder.
Different reports:
* emailable-report.html
* index.html

Refer [Guru99 TestNG reports](https://www.guru99.com/testng-report.html) for understanding testng reports.

Note: If no report folder is created, make sure to: Edit Config(Run suite) >> Listeners >> User Default Listeners.


