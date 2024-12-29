package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="userName")
	private WebElement unTbx;
	@FindBy(id="passWord")
	private WebElement pwdTbx;
	@FindBy(css="input[title='Sign In']")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void login(String un,String pwd)
	{
		unTbx.sendKeys(un);
		pwdTbx.sendKeys(pwd);
		loginBtn.click();
	}
}