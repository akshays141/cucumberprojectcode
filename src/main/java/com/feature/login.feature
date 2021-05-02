Feature: JBK offline application


Scenario: Login test
Given user should be on login page
When user enters uname and pass and click login button
Then user will be on home page


Scenario: verify logo
Given user should be on login page for logo
Then user should see JBK logo


Scenario: verify title Of loginpage
Then verifying title of Login Page


Scenario: verify Url of LoginPage
Then  verify Url of LoginPage

@login
Scenario: verify error messages for invalid Login credentials
Then verify error messages for invalid Login credentials