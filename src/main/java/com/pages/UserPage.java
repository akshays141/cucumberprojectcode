package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	WebDriver driver;
	int row=2;
	
	public UserPage(WebDriver driver) {          //constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Add User']")
	private WebElement addUserButton;

	@FindBy(xpath="//th")
	private List<WebElement>headers;
	
	@FindBy(xpath="//td[1]")
	private List<WebElement>srno;
	
	@FindBy(xpath="//td[2]")
	private List<WebElement> names;
	
	@FindBy(xpath="//td[3]")
	private List<WebElement>emails;
	
	@FindBy(xpath="//td[7]")
	private List<WebElement> states;
	
	public  boolean checkgmailIsProper(){
		
		for(WebElement element:emails){
			String text=element.getText();
			boolean flag=text.contains("gmail.com");
			System.out.println(flag);
		}
		return true;
	}
	
	public ArrayList<String> checksrno(){
		ArrayList<String>actData=new ArrayList<>();
		for(WebElement element:srno){
			String text=element.getText();
			actData.add(text);
		}
		return actData;
	}
	
	public ArrayList<String> verifyNamesForMahararshtra(){
		
		ArrayList<String>actData=new ArrayList<>();
		for(WebElement element : states) 
		{
			if(element.getText().equals("Maharashtra")) 	
			{  
				int index= states.indexOf(element)+2;
				//String name=names.get(index).getText();
				String name=driver.findElement(By.xpath("//tr["+index+"]/td[2]")).getText();
				System.out.println(name);      
				actData.add(name);
			}
		}
		return actData;
	}
	
	public ArrayList<String> checkHeaders(){
		ArrayList<String>actData=new ArrayList<>();
		for(WebElement element:headers)
		{
			String text=element.getText();
			actData.add(text);
		}
		return actData;
	}
	
	public AddUserPage clickAddUser(){
		addUserButton.click();
		return new AddUserPage(driver);
	}

	public ArrayList<String> getUserTableRowdata(int row){
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
