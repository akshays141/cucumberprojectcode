package com.stepDefs;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.OperatorPg;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.junit.Assert;

public class OperatorStepDef {
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
	Sheet sh=wb.getSheet("operator");
	int col =sh.getRow(row).getLastCellNum();
	for(int i=0;i<col;i++){
		if(i==0 && row>0){
			
			Cell cell= sh.getRow(row).getCell(i);
			String value = String.valueOf((long)cell.getNumericCellValue());
			al.add("0"+value);
		}else{
		Cell cell= sh.getRow(row).getCell(i);
		if(cell.getCellTypeEnum()==CellType.STRING)
			al.add(cell.getStringCellValue());
		
		else if(cell.getCellTypeEnum()==CellType.NUMERIC){
			String value = String.valueOf((long)cell.getNumericCellValue());
			al.add(value);
		}
		}
	}
	return al;
	}
	
	WebDriver driver;
	LoginPage lp = null;
	DashboardPage dp = null;
	OperatorPg op=null;

	@Before("@operator")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		dp=lp.validLogin();
		op=dp.clickOperatorBtn();
	}

	@After("@operator")
	public void tearDown() {
		driver.close();
	}
	@Then("^check all teacher names present on sunday$")
	public void check_all_teacher_names_present_on_sunday() throws Throwable {
		ArrayList <String>expData = new ArrayList <>();
		expData.add("Neelam");
		expData.add("Seema");
		Assert.assertEquals(expData,op.teachersNotPresentOnSunday() );
	}
	@Then("^check all teacher names on monday$")
	public void check_all_teacher_names_on_monday() throws Throwable {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		Assert.assertEquals(expData,op.teacherPresentOnMonday() );
	}
	@Then("^check all teacher names on monday and saturday$")
	public void check_all_teacher_names_on_monday_and_saturday() throws Throwable {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		Assert.assertEquals(expData,op.teacherPresentOnMondaySaturday() );
		
	}
	@Then("^check all teacher names on sunday$")
	public void check_all_teacher_names_on_sunday() throws Throwable {
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Varsha");
		expData.add("Darshit");
		Assert.assertEquals(expData,op.teacherPresentOnSunday() ); 
	}
	
	@Then("^check all PersonsNames for mobno starting with (\\d+)$")
	public void check_all_PersonsNames_for_mobno_starting_with(int arg1) throws Throwable {
		 ArrayList<String> expData = new ArrayList<String>();
			expData.add("Seema");
			expData.add("Varsha");
			expData.add("Darshit");
			Assert.assertEquals(expData,op.teachersNamesForMobNoStarting88());
	}
	@Then("^validating OperatorTable data with Excel$")
	public void validating_OperatorTable_data_with_Excel() throws Throwable {
		 while(row<6){
			 for(int i=0;i<readRow(row-1).size()-1;i++)
	        	Assert.assertEquals(readRow(row-1).get(i), op.getOperatorTableRowdata(row).get(i));	
	        	row++;
	        }
	}
}
