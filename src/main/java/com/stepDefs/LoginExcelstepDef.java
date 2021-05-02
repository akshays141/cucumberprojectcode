package com.stepDefs;

import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import jxl.Sheet;
import jxl.Workbook;

public class LoginExcelstepDef {
	WebDriver driver;
	FileInputStream fis=null;
	Workbook wb=null;
	Sheet sh=null;

	@Before("@excel1")
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	@After("@excel1")
	public void tearDown(){
		driver.close();
	}
	
	public String getData(int row,int col){
		try{
			 fis=new FileInputStream("register.xls");
			 wb=Workbook.getWorkbook(fis);
			 sh=wb.getSheet("loginTitle");
		}catch(Exception e){e.printStackTrace();}
		return sh.getCell(col, row).getContents();
	}
	
@Given("^user should be on loginPage for Excel(\\d+)$")
public void user_should_be_on_loginPage_for_Excel(int arg1) throws Throwable {
	driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
	driver.manage().window().maximize(); 
    
}

@When("^user should enter uname and password from excelSheet(\\d+) and click SignIn button$")
public void user_should_enter_uname_and_password_from_excelSheet_and_click_SignIn_button(int arg1) throws Throwable {
	for(int i=1;i<=3;i++)
	  {
		 if(driver.getTitle().contains("Dashboard"))
			 driver.findElement(By.linkText("LOGOUT")).click();
		 driver.findElement(By.id("email")).clear();
		 driver.findElement(By.id("email")).sendKeys(getData(i,0));
		 driver.findElement(By.id("password")).clear();
		 driver.findElement(By.id("password")).sendKeys(getData(i,1));
		 driver.findElement(By.xpath("//button")).click();
		 
		Assert.assertEquals(getData(i,2), driver.getTitle());
	  } 
    
}


}
