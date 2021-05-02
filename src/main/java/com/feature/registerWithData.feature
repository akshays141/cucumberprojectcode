@rgdata
Feature: JbK offline Application
Scenario Outline: verify register page using dataTable
Given user should be on loginPg and click registerLink 
When user enter "<name>" and "<mobile>" and "<email>" and "<password>" and click submit button
Then verify alert messages



Examples:
|name|mobile|email|password|
|Nayan|8666662131|nayan@gmail.com|water|
|Suhana|8777777771|suhana@gmail.com|iii|
|Ania|9988821351|ania11@gmail.com|sss|