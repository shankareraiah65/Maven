package com.crm.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.BaseClass;
import com.crm.generic.FileLibrary;
import com.crm.pom.CampaignPage;

@Listeners(com.crm.generic.ListenerImplementation.class)
public class CampaignModule extends BaseClass {
	@Test
	public void createCampaign() throws EncryptedDocumentException, IOException 
	{	
		CampaignPage cp = new CampaignPage(driver);
		String newCampName = f.getExcelData("createCampaign", 1, 1);
		String startDate = f.getExcelData("createCampaign", 1, 2);
//		String endDate = f.getExcelData("createCampaign", 1, 3);
//		String type = f.getExcelData("createCampaign", 1, 4);
//		String status = f.getExcelData("createCampaign", 1, 5);
//		String expectedRevenue = f.getExcelData("createCampaign", 1, 6);
//		String actualCost = f.getExcelData("createCampaign", 1, 7);
//		String numSent = f.getExcelData("createCampaign", 1, 8);
//		String budgetedCost = f.getExcelData("createCampaign", 1, 9);
//		String expectedResponse = f.getExcelData("createCampaign", 1, 10);
		
		System.out.println("New CampName :"+newCampName);
		System.out.println("Start Date :"+startDate);
		
		
		cp.getNewCampMinorTab().click();
		cp.getCampNameTbx().sendKeys(newCampName);
		cp.getStartDateTbx().sendKeys(startDate);
//		cp.getEndDateTbx().sendKeys(endDate);
//		Select type1 = new Select(cp.getTypeListBox());
//		type1.selectByVisibleText(type);
//		Select status1 = new Select(cp.getStatusListBox());
//		status1.selectByVisibleText(status);
//		cp.getExpectedRevenueTbx().sendKeys(expectedRevenue);
//		cp.getActualCostTbx().sendKeys(actualCost);
//		cp.getNumSentTbx().sendKeys(numSent);
//		cp.getBudgetedCostTbx().sendKeys(budgetedCost);
//		cp.getExpectedResponseTbx().sendKeys(expectedResponse);
		cp.getSaveBtn().click();
		String campName = cp.getCreatedCampName().getText();

		Assert.assertEquals(campName, newCampName);
		Reporter.log("Campaign created",true);
	}
	
	@Test
	public void deleteCampaign() throws InterruptedException
	{
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampMajorTab().click();
		cp.getDeleteCreatedCamp().click();
		cp.getDeleteBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Reporter.log("Campaign deleted",true);
	}
}
