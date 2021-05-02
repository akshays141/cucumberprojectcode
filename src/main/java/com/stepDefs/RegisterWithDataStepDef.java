package com.stepDefs;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;
import com.pages.RegisterPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterWithDataStepDef {
	WebDriver driver;
	LoginPage lp = null;
	RegisterPage rp=null;

	@Before("@rgdata")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After("@rgdata")
	public void tearDown() {
		driver.close();
	}
	
@Given("^user should be on loginPg and click registerLink$")
public void user_should_be_on_loginPg_and_click_registerLink() throws Throwable {
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.manage().window().maximize();
	lp=new LoginPage(driver);
	rp=lp.clickRegisterLink();
}

@When("^user enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and click submit button$")
public void user_enter_and_and_and_and_click_submit_button(String name, String mobile, String email, String password) throws Throwable {
	rp.enterName(name);
	rp.enterMobno(mobile);
	rp.enterUsername(email);
	rp.enterPassword(password);
	 rp.clickLoginButton();   
}
@Then("^verify alert messages$")
public void verify_alert_messages() throws Throwable {
Alert al=driver.switchTo().alert();
Assert.assertEquals("User registered successfully.", al.getText());
  al.accept();  
}

}
