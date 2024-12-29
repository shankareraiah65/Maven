package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	@FindBy(linkText="Campaigns")
	private WebElement campMajorTab;
	
	@FindBy(linkText="New Campaign")
	private WebElement newCampMinorTab;
	
	@FindBy(name="property(Campaign Name)")
	private WebElement campNameTbx;
	
	@FindBy(name="property(Start Date)")
	private WebElement startDateTbx;
	
	@FindBy(name="property(End Date)")
	private WebElement endDateTbx;
	
	@FindBy(name="property(Type)")
	private WebElement typeListBox;
	
	@FindBy(name="property(Status)")
	private WebElement statusListBox;
	
	@FindBy(name="property(Expected Revenue)")
	private WebElement expectedRevenueTbx;
	
	@FindBy(name="property(Actual Cost)")
	private WebElement actualCostTbx;
	
	@FindBy(name="property(Num sent)")
	private WebElement numSentTbx;
	
	@FindBy(name="property(Budgeted Cost)")
	private WebElement budgetedCostTbx;
	
	@FindBy(name="property(Expected Response)")
	private WebElement expectedResponseTbx;
	
	@FindBy(css="input[value='Save']")
	private WebElement saveBtn;
	
	@FindBy(css="input[value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(id="value_Campaign Name")
	private WebElement createdCampName;
	
	@FindBy(linkText="Praveen Laptop Expo")
	private WebElement deleteCreatedCamp;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCampMajorTab()
	{
		return campMajorTab;
	}
	
	public WebElement getNewCampMinorTab()
	{
		return newCampMinorTab;
	}
	
	public WebElement getCampNameTbx()
	{
		return campNameTbx;
	}
	
	public WebElement getStartDateTbx()
	{
		return startDateTbx;
	}
	
	public WebElement getEndDateTbx()
	{
		return endDateTbx;
	}
	
	public WebElement getTypeListBox()
	{
		return typeListBox;
	}
	
	public WebElement getStatusListBox()
	{
		return statusListBox;
	}
	
	public WebElement getExpectedRevenueTbx()
	{
		return expectedRevenueTbx;
	}
	
	public WebElement getActualCostTbx() 
	{
		return actualCostTbx;
	}
	
	public WebElement getNumSentTbx()
	{
		return numSentTbx;
	}
	
	public WebElement getBudgetedCostTbx()
	{
		return budgetedCostTbx;
	}
	
	public WebElement getExpectedResponseTbx()
	{
		return expectedResponseTbx;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	public WebElement getCreatedCampName()
	{
		return createdCampName;
	}
	
	public WebElement getDeleteCreatedCamp()
	{
		return deleteCreatedCamp;
	}
	
	public WebElement getDeleteBtn() 
	{
		return deleteBtn;
	}
}
