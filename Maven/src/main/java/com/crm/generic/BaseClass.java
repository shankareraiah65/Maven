package com.crm.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.crm.generic.FileLibrary;
import com.crm.pom.LoginPage;
import com.crm.pom.HomePage;

public class BaseClass
{
	public static WebDriver driver;
	public static FileLibrary f=new FileLibrary();
	@BeforeTest
	public void openBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.getPropertyData("url");
		driver.get(url);
		Reporter.log("open browser",true);
	}
	@BeforeMethod
	public void login() throws IOException
	{
		String un = f.getPropertyData("un");
		String pwd = f.getPropertyData("pwd");
		LoginPage l=new LoginPage(driver);
		l.login(un,pwd);
		Reporter.log("login",true);
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{
		HomePage h=new HomePage(driver);
		Thread.sleep(2000);
		h.setLogout();
		Reporter.log("logout",true);
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("close browser",true);
	}
}
