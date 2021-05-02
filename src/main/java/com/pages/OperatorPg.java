package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorPg {
WebDriver driver;

	public OperatorPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[2]")
	private List<WebElement> personNames;
	@FindBy(xpath="//td[6]")
	private List<WebElement>timings;
	@FindBy(xpath="//td[5]")
	private List<WebElement>mob;
	
	public ArrayList<String> teachersNamesForMobNoStarting88(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:mob){
			String text=element.getText();
			if(text.substring(0,2).equals("88"))
			{
				int index=mob.indexOf(element)+2;      //row2 names
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);
				actData.add(name);
			}
		}
	return actData;
	}
	
	public ArrayList<String> teachersNotPresentOnSunday(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(!text.contains("Sunday"))
			{
				int index=timings.indexOf(element)+2;      //row2 names
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);
				actData.add(name);
			}
		}
	return actData;
	}
	
	public ArrayList<String> teacherPresentOnMonday(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Monday"))
			{
				int index=timings.indexOf(element)+2;      //row2 names
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);
				actData.add(name);
			}	
		}
		return actData;
	}
	public ArrayList<String> teacherPresentOnSunday(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Sunday"))
			{
				int index=timings.indexOf(element)+2;      //row2 names
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);
				actData.add(name);
			}	
		}
		return actData;
	}
	
	
	public ArrayList<String> teacherPresentOnMondaySaturday(){
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Monday") && text.contains("Saturday"))
			{
				int index=timings.indexOf(element)+2;      //row2 names
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);
				actData.add(name);
			}	
		}
		return actData;
	}
	public ArrayList<String> getOperatorTableRowdata(int row){
		ArrayList<String> actData = new ArrayList<String>();
			if(row==1){
				List<WebElement>rowData1= driver.findElements(By.xpath("//th"));
				for(WebElement ele:rowData1)
				{
					String text=ele.getText();
					actData.add(text);
				}
			}
			else{
			List<WebElement>rowData1= driver.findElements(By.xpath("//tr["+row+"]/td"));
				for(WebElement ele:rowData1)
				{
					String text=ele.getText();
					actData.add(text);
				}
			}
		return actData;
	}
}