SeleniumFramework for automated testing

This is the sample framework for a sample login application

Files Details
CreateDriver.java
This file contains all the browser configurations.

AppLoginPO
For every page, we will create one file that will contain all webdriver elements and the logic.
    
LoginPageTest
All test cases methods are present in this file. We can create one file for each page

Login.json
All test data will be present in this file. We can create one file for each page

Testng.xml
All configurations which group to run and on which browsers etc.


How to run it manually using maven

mvn test -Denv="https://test.tri-mpronav.com/login/index"

You can pass groups also, which group you want to run 

mvn test -Dgroups=FUNCTIONAL_TEST_GROUP,REGRESSION_TEST_GROUP
