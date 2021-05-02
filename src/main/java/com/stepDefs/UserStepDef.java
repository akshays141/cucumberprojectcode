package com.stepDefs;


import java.util.ArrayList;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.junit.Assert;

public class UserStepDef {
	WebDriver driver;
	LoginPage lp=null;
	DashboardPage dp=null;
	UserPage up=null;
	static int row=2;

	
	@Before("@user")
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		}
	@After("@user")
	public void tearDown(){
		driver.close();
	}
	@Given("^User should be on loginPg for validating userTable$")
	public void user_should_be_on_loginPg_for_validating_userTable() throws Throwable {
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();   
	   lp=new LoginPage(driver);
	}

	@When("^perform valid login and click users link$")
	public void perform_valid_login_and_click_users_link() throws Throwable {
	    dp=lp.validLogin();
	   up=dp.clickUserBtn();
	}
	
	@Then("^verify the headings \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_headings_and_and_and_and_and_and_and(String sr, String name, String email, String mob, String course, String gender, String state, String action) throws Throwable {

		ArrayList<String>expData=new ArrayList<>();
		expData.add(sr);
		expData.add(name);
		expData.add(email);
		expData.add(mob);
		expData.add(course);
		expData.add(gender);
		expData.add(state);
		expData.add(action);
		Assert.assertEquals(expData,up.checkHeaders());;
	}
	@When("^user do valid login from loginPg and click userLink$")
	public void user_do_valid_login_from_loginPg_and_click_userLink() throws Throwable {
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();   
	   lp=new LoginPage(driver);
	   dp=lp.validLogin();
	   up=dp.clickUserBtn();
	}
	
@Then("^validating the data present in UserTable as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
public void validating_the_data_present_in_UserTable_as_and_and_and_and_and_and_and(String sr, String name, String email, String mobile, String course, String gender, String state, String action) throws Throwable {
	
	ArrayList<String> expData = new ArrayList<String>();
	expData.add(sr);
	expData.add(name);
	expData.add(email);
	expData.add(mobile);
	expData.add(course);
	expData.add(gender);
	expData.add(state);
	expData.add(action);
	Assert.assertEquals(expData,up.getUserTableRowdata(row) );
	row++;
}
@Then("^check the list of persons belonging to Maharashtra$")
public void check_the_list_of_persons_belonging_to_Maharashtra() throws Throwable {
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	lp=new LoginPage(driver);
	dp=lp.validLogin();
	up=dp.clickUserBtn();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add("Kiran");
	expData.add("Monica");
	//System.out.println(up.verifyNamesForMahararshtra());
	Assert.assertEquals(expData,up.verifyNamesForMahararshtra());
}

@Then("^check serialno incrementation$")
public void check_serialno_incrementation() throws Throwable {
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	lp=new LoginPage(driver);
	dp=lp.validLogin();
	up=dp.clickUserBtn();
	ArrayList<String> expData = new ArrayList<String>();
	expData.add("1");
	expData.add("2");
	expData.add("3");
	expData.add("4");
	Assert.assertEquals(up.checksrno(),expData);
}
@Then("^check the emails present in UserTable have gmail\\.com$")
public void check_the_emails_present_in_UserTable_have_gmail_com() throws Throwable {
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	lp=new LoginPage(driver);
	dp=lp.validLogin();
	up=dp.clickUserBtn();
	Assert.assertTrue(up.checkgmailIsProper());
}
}
