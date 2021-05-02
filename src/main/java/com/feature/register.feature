@register
Feature: RegisterPage

Scenario: check register link
Given user should be on login page for registering a member
When  user click on register link
When  user should enter the name mobile email password
When click on submit button
Then alert box appears

Scenario: error msgs
Given user should be on login page for registering a new member
When  user should click on register link 
When  user is not entering the name mobile email password
When click on submit button
Then error messages occurs