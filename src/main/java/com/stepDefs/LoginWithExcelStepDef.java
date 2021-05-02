package com.stepDefs;

import java.io.FileInputStream;

import org.openqa.selenium.By;
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
import jxl.Sheet;
import jxl.Workbook;

public class LoginWithExcelStepDef {
	WebDriver driver;
	LoginPage lp=null;
	DashboardPage dp=null;
	
	FileInputStream fis=null;
	Workbook wb=null;
	Sheet sh=null;
	
	@Before("@excel")
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
	}
	@After("@excel")
	public void tearDown(){
		driver.close();
	}
	
	public String getData(int row,int col){
		try{
			 fis=new FileInputStream("register.xls");
			 wb=Workbook.getWorkbook(fis);
			 sh=wb.getSheet("login");
		}catch(Exception e){e.printStackTrace();}
		return sh.getCell(col, row).getContents();
	}
	@Given("^user should be on loginPage for Excel$")
	public void user_should_be_on_loginPage_for_Excel() throws Throwable {
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();    
		
	}

	@When("^user should enter uname and password from excelSheet and click SignIn button$")
	public void user_should_enter_uname_and_password_from_excelSheet_and_click_SignIn_button() throws Throwable {
	  for(int i=1;i<=3;i++)
	  {
		 driver.findElement(By.id("email")).clear();
		 driver.findElement(By.id("email")).sendKeys(getData(i,0));
		 driver.findElement(By.id("password")).clear();
		 driver.findElement(By.id("password")).sendKeys(getData(i,1));
		 driver.findElement(By.xpath("//button")).click();
		 
		 if(driver.getTitle().contains("Dashboard"))
			 driver.findElement(By.linkText("LOGOUT")).click();
	  }  
	}

	@Then("^user will verify the title of HomePg$")
	public void user_will_verify_the_title_of_HomePg() throws Throwable {
		Assert.assertEquals("JavaByKiran | Log in", driver.getTitle()); 
	  
	}
}
