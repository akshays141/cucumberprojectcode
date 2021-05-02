@lgdata
Feature: JBK Offline Application
Scenario Outline: Login Test with dataTable
Given User should launch "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html"
When user enters "<uname>" and "<pass>" and click login button
Then user will verify home page title

Examples:
|uname|pass|
|kiran@gmail.com|123456|
|sagar@gmail.com|qwerty|
|neelam@gmail.com|11111|