package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(linkText="Leads")
	private WebElement leadsMajorTab;
	
	@FindBy(linkText="New Lead")
	private WebElement newLeadMinorTab;
	
	@FindBy(name="property(First Name)")
	private WebElement firstNameTbx;
	
	@FindBy(name="property(Last Name)")
	private WebElement lastNameTbx;
	
	@FindBy(name="property(Company)")
	private WebElement companyTbx;
	
	@FindBy(name="property(Lead Source)")
	private WebElement leadSourceListBox;
	
	@FindBy(name="Button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[text()='Prafull Ullagedde']")
	private WebElement createdLeadName;
	
	@FindBy(css="input[value='Delete']")
	private WebElement deleteBtn;
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLeadMajorTab()
	{
		return leadsMajorTab;
	}
	
	public WebElement getNewLeadMinorTab()
	{
		return newLeadMinorTab;
	}
	
	public WebElement getFirstName()
	{
		return firstNameTbx;
	}
	
	public WebElement getLastName()
	{
		return lastNameTbx;
	}
	
	public WebElement getCompany()
	{
		return companyTbx;
	}
	
	public WebElement getLeadSourceListBox()
	{
		return leadSourceListBox;
	}
	
	public WebElement getCreatedLeadName()
	{
		return createdLeadName;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	public WebElement getDeleteBtn()
	{
		return deleteBtn;
	}
}
