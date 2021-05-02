package com.stepDefs;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pages.LoginPage;
import com.pages.RegisterPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;


public class RegisterStepDef {
	WebDriver driver;
	LoginPage lp=null;
	RegisterPage rp=null;
	
	@Before("@register")
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();	
	}
	@After("@register")
	public void tearDown(){
		driver.close();
	}
	@Given("^user should be on login page for registering a member$")
	public void user_should_be_on_login_page_for_registering_a_member() throws Throwable {
		
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize(); 
		
	}

	@When("^user click on register link$")
	public void user_click_on_register_link() throws Throwable {
		lp=new LoginPage(driver);
	    rp=lp.clickRegisterLink();
	  }

	@When("^user should enter the name mobile email password$")
	public void user_should_enter_the_name_mobile_email_password() throws Throwable {
		  rp.enterName("heena");
		   rp.enterMobno("5555");
		   rp.enterUsername("geet@gmail.com");
		   rp.enterPassword("uuu");
	   
	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
	   
		 rp.clickLoginButton();
	}

	@Then("^alert box appears$")
	public void alert_box_appears() throws Throwable {
	   Alert al=driver.switchTo().alert();
	   String msg=al.getText();
	   
	  Assert.assertEquals("User registered successfully.", msg);
	   al.accept();
	    
	}

	@Given("^user should be on login page for registering a new member$")
	public void user_should_be_on_login_page_for_registering_a_new_member() throws Throwable {
	   driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize(); 
		}

	@When("^user should click on register link$")
	public void user_should_click_on_register_link() throws Throwable {
	   
		lp=new LoginPage(driver);
	    rp=lp.clickRegisterLink(); 
	}

	@When("^user is not entering the name mobile email password$")
	public void user_is_not_entering_the_name_mobile_email_password() throws Throwable {
		   rp.enterName("");
		   rp.enterMobno("");
		   rp.enterUsername("");
		   rp.enterPassword("");    
	}

	@Then("^error messages occurs$")
	public void error_messages_occurs() throws Throwable {
		ArrayList<String>al=new ArrayList<String>();
		al.add("Please enter Name.");
		al.add("Please enter Mobile.");
		al.add("Please enter Email.");
		al.add("Please enter Password.");
		
		int i=0;
		List<WebElement>errmsgs=driver.findElements(By.xpath("//div[contains(@id,'error')]"));
		for(WebElement errormsg:errmsgs)
		{
			String actualText=errormsg.getText();
			Assert.assertEquals(actualText, al.get(i));
			i++;
		}
	}

}
