Feature: JBK application Operator Pg


Scenario: verify teacher not present on sunday
Then check all teacher names present on sunday


Scenario: verify teacher present on monday
Then check all teacher names on monday


 Scenario: verify teacher present on monday and saturday
 Then check all teacher names on monday and saturday
 
 
  Scenario: verify teacher present on sunday
  Then check all teacher names on sunday
  
 
   Scenario: verifyNames For MobileNos  starting with 88
   Then check all PersonsNames for mobno starting with 88
   
 @operator  
   Scenario: validating OperatorTable data with Excel
   Then validating OperatorTable data with Excel