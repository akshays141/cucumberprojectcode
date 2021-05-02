Feature: Jbk offline application

Scenario Outline: verify Heading of User Table

Given User should be on loginPg for validating userTable 
When perform valid login and click users link
Then verify the headings "<sr>" and "<name>" and "<email>" and "<mob>" and "<course>" and "<gender>" and "<state>" and "<action>"
Examples:
|sr|name|email|mob|course|gender|state|action|
|#|Username|Email|Mobile|Course|Gender|State|Action|


Scenario Outline: verify userTable data

When user do valid login from loginPg and click userLink
Then validating the data present in UserTable as "<sr>" and "<name>" and "<email>" and "<mob>" and "<course>" and "<gender>" and "<state>" and "<action>"
Examples:
|sr|name|email|mob|course|gender|state|action|
|1|Kiran|kiran@gmail.com|9898989898|Java/J2EE|Male|Maharashtra|Delete|
|2|Sagar|sagar@gmail.com|999999999|Selenium|Male|Punjab|Delete|
|3|Monica|monica@gmail.com|1111111111|Python|Female|Maharashtra|Delete|
|4|Kimaya|kimaya@gmail.com|999999999|PHP|Female|Punjab|Delete|

@userExcel
Scenario: verify userTable data

When user will read the data from excel
Then validating the data present in UserTable with excel data


Scenario: verify person belonging to Maharashtra

Then check the list of persons belonging to Maharashtra


Scenario: verify table srno
Then check serialno incrementation

@user
Scenario: unames contains gmail.com
Then check the emails present in UserTable have gmail.com




