package com.stepDefs;

import java.io.FileInputStream;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UserTableVerifyWithExcel {
	static int row =1;
	

	public ArrayList<String> readRow(int row){
	FileInputStream fis=null;
	Workbook wb=null;
	ArrayList<String> al = new ArrayList<String>();
	try {
		fis = new FileInputStream("Data.xlsx");
		wb=WorkbookFactory.create(fis);
	} catch (Exception e) {
		e.printStackTrace();
	}
	Sheet sh=wb.getSheet("user");
	int col =sh.getRow(row).getLastCellNum();
	for(int i=0;i<col;i++){
		Cell cell= sh.getRow(row).getCell(i);
		if(cell.getCellTypeEnum()==CellType.STRING)
			al.add(cell.getStringCellValue());
		
		else if(cell.getCellTypeEnum()==CellType.NUMERIC){
			String value = String.valueOf((long)cell.getNumericCellValue());
			al.add(value);
		}
	}
	return al;
	}
	
	WebDriver driver;
	LoginPage lp;
	UserPage up;
	DashboardPage dp;
	
	@Before("@userExcel")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		dp = lp.validLogin();
		up = dp.clickUserBtn();
	}
	
	@After("@userExcel")
	public void tearDown(){
		driver.close();
	}
	
	@When("^user will read the data from excel$")
	public void user_will_read_the_data_from_excel() throws Throwable {
	    
	}

	@Then("^validating the data present in UserTable with excel data$")
	public void validating_the_data_present_in_UserTable_with_excel_data() throws Throwable {
		//Assert.assertEquals(readRow(row-1), up.getUserTableRowdata(row));  //static int row=1
		//Assert.assertEquals(readRow(row), up.getUserTableRowdata(rows)); //static int row=0,rows=1
		
	     while(row<6){
	        	Assert.assertEquals(readRow(row-1), up.getUserTableRowdata(row));	
	        	row++;
	        }
	}
}
