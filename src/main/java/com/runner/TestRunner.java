package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
	
	features="src/main/java/com/feature",
	glue= "com.stepDefs",
	tags={"@operator"},
    format= {"pretty","html:test-output"}
	//staging area (Area between local rep & remote)
)

//[01, Kiran, Urgent Technical Help, Whats App Only, 9552343698, 07:00 AM to 10:00 PM Monday-Sunday]
//[01, Kiran, Urgent Technical Help, Whats App Only, 9552343698, 07:00 AM to 10:00 PM Monday-Sunday]



public class TestRunner {
// ~ =not to run that tag ie not run that feature file or the scenario
//monochrome= true,
//	dryRun=false for Execution    dryRun=true for compiling
//Feature file:Select package--New--Others--File--FileName:loginWithData.feature
//tags={"@excel,@excel1"}
//tags={"@login,~@register"} not register to run just login
	//String value = String.valueOf((long)cell.getNumericCellValue());
	//staging area (Area between local rep & remote)
}
