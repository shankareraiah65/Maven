package com.crm.testscripts;

import java.io.IOException;
import java.util.Date;

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
	public void createCampaign() throws EncryptedDocumentException, IOException, InterruptedException 
	{	
		CampaignPage cp = new CampaignPage(driver);
		String newCampName = f.getExcelData("createCampaign", 1, 1);
		int startDate = (int)f.getExcelDataNumeric("createCampaign", 1, 2);
		int endDate = (int)f.getExcelDataNumeric("createCampaign", 1, 3);
		String stDate = String.valueOf(startDate);
		String start = stDate.substring(0, 2)+"/"+stDate.substring(2, 4)+"/"+stDate.substring(4, 8);
		String enDate = String.valueOf(endDate);
		String end = enDate.substring(0, 2)+"/"+enDate.substring(2, 4)+"/"+enDate.substring(4, 8);
		String type = f.getExcelData("createCampaign", 1, 4);
		String status = f.getExcelData("createCampaign", 1, 5);
		int expectedRevenue = (int)f.getExcelDataNumeric("createCampaign", 1, 6);
		int actualCost = (int)f.getExcelDataNumeric("createCampaign", 1, 7);
		int numSent = (int)f.getExcelDataNumeric("createCampaign", 1, 8);
		int budgetedCost = (int)f.getExcelDataNumeric("createCampaign", 1, 9);
		int expectedResponse = (int)f.getExcelDataNumeric("createCampaign", 1, 10);
		
//		System.out.println("New CampName :"+newCampName);
//		System.out.println("Start Date :"+startDate);
		
		
		cp.getNewCampMinorTab().click();
		cp.getCampNameTbx().sendKeys(newCampName);
		
		 cp.getStartDateTbx().sendKeys(String.valueOf(start));
		 cp.getEndDateTbx().sendKeys(String.valueOf(end));
		 
		Select type1 = new Select(cp.getTypeListBox());
		type1.selectByVisibleText(type);
		Select status1 = new Select(cp.getStatusListBox());
		status1.selectByVisibleText(status);
		cp.getExpectedRevenueTbx().sendKeys(String.valueOf(expectedRevenue));
		cp.getActualCostTbx().sendKeys(String.valueOf(actualCost));
		cp.getNumSentTbx().sendKeys(String.valueOf(numSent));
		cp.getBudgetedCostTbx().sendKeys(String.valueOf(budgetedCost));
		cp.getExpectedResponseTbx().sendKeys(String.valueOf(expectedResponse));
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
