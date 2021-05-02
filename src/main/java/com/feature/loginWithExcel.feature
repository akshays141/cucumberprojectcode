@excel
Feature: JBK Offline Website
Scenario: login test
Given user should be on loginPage for Excel 
When  user should enter uname and password from excelSheet and click SignIn button
Then  user will verify the title of HomePg
