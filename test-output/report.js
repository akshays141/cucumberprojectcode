$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("operator.feature");
formatter.feature({
  "line": 1,
  "name": "JBK application Operator Pg",
  "description": "",
  "id": "jbk-application-operator-pg",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5075956200,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "validating OperatorTable data with Excel",
  "description": "",
  "id": "jbk-application-operator-pg;validating-operatortable-data-with-excel",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@operator"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "validating OperatorTable data with Excel",
  "keyword": "Then "
});
formatter.match({
  "location": "OperatorStepDef.validating_OperatorTable_data_with_Excel()"
});
formatter.result({
  "duration": 2657265700,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cTechnical Discussion[](Errors, Software, T...\u003e but was:\u003cTechnical Discussion[ ](Errors, Software, T...\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.stepDefs.OperatorStepDef.validating_OperatorTable_data_with_Excel(OperatorStepDef.java:125)\r\n\tat ✽.Then validating OperatorTable data with Excel(operator.feature:25)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 115207900,
  "status": "passed"
});
});