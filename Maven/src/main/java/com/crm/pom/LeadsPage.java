package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(linkText="Leads")
	private WebElement leadsTab;
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLeadTab()
	{
		return leadsTab;
	}
}
