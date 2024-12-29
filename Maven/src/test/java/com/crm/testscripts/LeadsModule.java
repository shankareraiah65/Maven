package com.crm.testscripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.BaseClass;
import com.crm.pom.LeadsPage;

@Listeners(com.crm.generic.ListenerImplementation.class)
public class LeadsModule extends BaseClass{
		@Test
	public void createLead() throws EncryptedDocumentException, IOException {
			
			String firstName = f.getExcelData("createLead", 1, 1);
			String lastName = f.getExcelData("createLead", 1, 2);
			String company = f.getExcelData("createLead", 1, 3);
			String leadSource = f.getExcelData("createLead", 1, 4);
			
			
			LeadsPage lp = new LeadsPage(driver);
			lp.getNewLeadMinorTab().click();
			lp.getFirstName().sendKeys(firstName);
			lp.getLastName().sendKeys(lastName);
			lp.getCompany().sendKeys(company);
			Select s= new Select(lp.getLeadSourceListBox());
			s.selectByVisibleText(leadSource);
			lp.getSaveBtn().click();
			Reporter.log("Lead created",true);
		}
	@Test
	public void deleteLead() throws InterruptedException {
		LeadsPage lp = new LeadsPage(driver);
		lp.getLeadMajorTab().click();
		lp.getCreatedLeadName().click();
		lp.getDeleteBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Reporter.log("Lead deleted",true);
	}


}