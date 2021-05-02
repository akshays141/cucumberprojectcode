package com.stepDefs;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pages.DashboardPage;
import com.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {
	WebDriver driver;
	LoginPage lp = null;
	DashboardPage dp = null;

	@Before("@login")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@After("@login")
	public void tearDown() {
		driver.close();
	}

	@Given("^user should be on login page$")
	public void user_should_be_on_login_page() throws Throwable {

		
	}

	@When("^user enters uname and pass and click login button$")
	public void user_enters_uname_and_pass_and_click_login_button() throws Throwable {
		
		lp.validLogin();

	}

	@Then("^user will be on home page$")
	public void user_will_be_on_home_page() throws Throwable {

		Assert.assertEquals("JavaByKiran | Dashboard", driver.getTitle());
	}

	@Given("^user should be on login page for logo$")
	public void user_should_be_on_login_page_for_logo() throws Throwable {

		
	}

	@Then("^user should see JBK logo$")
	public void user_should_see_JBK_logo() throws Throwable {

		Assert.assertTrue(lp.displayImage());
	}
	@Then("^verifying title of Login Page$")
	public void verifying_title_of_Login_Page() throws Throwable {
		Assert.assertEquals("JavaByKiran | Log in", driver.getTitle());
	}
	@Then("^verify Url of LoginPage$")
	public void verify_Url_of_LoginPage() throws Throwable {
		Assert.assertEquals("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html", driver.getCurrentUrl()); 
	}
	@Then("^verify error messages for invalid Login credentials$")
	public void verify_error_messages_for_invalid_Login_credentials() throws Throwable {
		 ArrayList<String>expData=new ArrayList<String>();
			expData.add("Please enter email.");
			expData.add("Please enter password.");
			lp.enterUsername("kk@gmail.com");
			lp.enterPassword("yyy");
			lp.clickLoginButton();
			Assert.assertEquals(lp.getErrorMsg(), expData);
	}
}
