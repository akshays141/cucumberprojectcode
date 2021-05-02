package com.stepDefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginWithDataStepDef {
	WebDriver driver;
	LoginPage lp = null;
	DashboardPage dp=null;

	@Before("@lgdata")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		lp=new LoginPage(driver);
		dp=new DashboardPage(driver);
	}

	@After("@lgdata")
	public void tearDown() {
		driver.close();
	}

@Given("^User should launch \"([^\"]*)\"$")
public void user_should_launch(String url) throws Throwable {
  driver.get(url);  
  
}

@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and click login button$")
public void user_enters_and_and_click_login_button(String uname, String pass) throws Throwable {
   /*driver.findElement(By.id("email")).sendKeys(uname);
   driver.findElement(By.id("password")).sendKeys(pass);
   driver.findElement(By.xpath("//button")).click();*/
	
	lp.enterUsername(uname);
	lp.enterPassword(pass);
	lp.clickLoginButton();
}

@Then("^user will verify home page title$")
public void user_will_verify_home_page_title() throws Throwable {
    
 /* if(driver.getTitle().contains("Dashboard")){
	  driver.findElement(By.partialLinkText("LOGOUT")).click();}
   Assert.assertEquals("JavaByKiran | Log in", driver.getTitle());*/
	
	if(driver.getTitle().contains("Dashboard"))
		dp.clickLogout();
	
	Assert.assertEquals("JavaByKiran | Log in", driver.getTitle());
	
	/*if(driver.getTitle().contains("Dashboard"))
		Assert.assertEquals("JavaByKiran | Dashboard", driver.getTitle());
	else
		Assert.assertEquals("JavaByKiran | Log in", driver.getTitle());
	*/
}
//https://github.com/mangesh1404/BDD10thApr.git

}
