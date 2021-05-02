package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="name")
private WebElement name;

@FindBy(id="mobile")
private WebElement mobile;

@FindBy(id="email")
private WebElement uname;

@FindBy(id="password")
private WebElement pass;

@FindBy(xpath="//button")
private WebElement loginButton;

@FindBy(xpath="//a[contains(text(),'I')]")
private WebElement alreadyMember;

public void enterName(String text){
	name.clear();
	name.sendKeys(text);
}
public void enterMobno(String text){
	mobile.clear();
	mobile.sendKeys(text);
}
public void enterUsername(String text) {
	uname.clear();
	uname.sendKeys(text);
}
public void enterPassword(String text) {
	pass.clear();
	pass.sendKeys(text);
}
public void clickLoginButton() {
	
	loginButton.click();
}
public LoginPage clickAlreadyAMember(){
	alreadyMember.click();
	return new LoginPage(driver);
}

public void registerAnyOne(String textname,String textmob,String texuname,String textpass){
	name.sendKeys(textname);
	mobile.sendKeys(textmob);
	uname.sendKeys(texuname);
	pass.sendKeys(textpass);
	loginButton.click();
	Alert al=driver.switchTo().alert();
	al.accept();
	//return new RegisterPage(driver);
}
}
