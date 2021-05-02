package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
WebDriver driver;
	
	public AddUserPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="mobile")
	private WebElement mob;

	@FindBy(id="course")
	private WebElement course;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(xpath="//input[@value='Male']")
	private WebElement maleradio;

	@FindBy(xpath="//input[@value='Female']")
	private WebElement femaleradio;
	
	@FindBy(xpath="//select")
	private WebElement selectstate;

	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitbutton;
	
	public void selectGenderRadioButton(String gender){
		if(gender.equals("Male"))
		maleradio.click();
		else
			femaleradio.click();
	}
	
	
	
	public void enterName(String text){
		username.clear();
		username.sendKeys(text);	
	}
	public void enterMob(String text){
		mob.clear();
		mob.sendKeys(text);	
	}
	public void enterEmail(String text){
		email.clear();
		email.sendKeys(text);	
	}
	public void enterPass(String text){
		pass.clear();
		pass.sendKeys(text);	
	}
	public void enterCourse(String text){
		course.clear();
		course.sendKeys(text);	
	}
	public void selectByText(String text){
		Select state=new Select(selectstate);
		state.selectByVisibleText(text);
	}
	
	
	public void clickSubmitButton(){
		submitbutton.click();
	}
}
