package com.training.test.Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class LoginTest extends BaseTest {

	WebDriver driver;
	LoginPage login;
	HomePage home;
	CommonUtilities common = new CommonUtilities();

	@BeforeMethod
	public void beforeTest() throws IOException, InterruptedException 
	{
		driver = getDriver();
		String Url = common.getApplicationProperty("url");
		driver.get(Url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		driver.manage().window().maximize();
		DOMConfigurator.configure("log4j.xml");

	}

	@Test(priority=1)
	public void LoginErrorMessage1() throws InterruptedException, IOException 
	{
		Log.startTestCase("TC 1 - Login Error Message");
		String Username = common.getApplicationProperty("Uname");
		login.logintapplication(Username,"");
		
		String errormessage=GetTextFun(login.errormessage(),"Error Message");
		assertFun(errormessage,login.expectedvalue);
		Log.info("TC1 completed successfully");
		Log.endTestCase("TC 1 - Login Error Message");    
	}

	@Test(priority=2)
	public void LoginToSalesForce2() throws Exception 
	{
		Log.startTestCase("TC 2- Login To SalesForce");
		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);
		
		login.implicitwait();		
		String actualTitle=getTitle();
		assertFun(actualTitle,login.expectedTitle);
		Log.info("TC2 successfully completed");
		Log.endTestCase("TC 2- Login To SalesForce");
	}

	@Test(priority=3)
	public void Check_RememberMe_3() throws Exception 
	{
		Log.startTestCase("TC 3- Check RememberMe");
		String Username = common.getApplicationProperty("Uname");		
		String Password = common.getApplicationProperty("pwd");
		login.checkrememberme(Username,Password);	
		login.implicitwait();	
		String actualTitl=getTitle();
		assertFun(actualTitl,login.expectedTitle);
		
		login.MenuClick();
		login.logout();
		login.implicitwait();		
		String actual_username=login.enterintoUsername().getAttribute("value");
		assertFun(actual_username,login.expected_username);	
		Log.info("TC 3 successfully completed");
		Log.endTestCase("TC 3- Check RememberMe");
	}
	
	@Test(priority=4)
	public void Forgot_Password_4_A() throws Exception 
	{
		Log.startTestCase("TC 4A - Forgot Password");
		String Username = common.getApplicationProperty("Uname");
		login.forgotPassword(Username);	
		login.implicitwait();
		
		String Title_forgotpassword=getTitle();
		assertFun(Title_forgotpassword,login.expected_forgotpassword);
		String Fname = common.getApplicationProperty("Uname");
		login.forgotpwdentervalue(Fname);
		
		String actual_message=getTitle();
		assertFun(actual_message,login.expected_message);
		Log.info("TC 4A successfully completed");
		Log.endTestCase("TC 4A - Forgot Password");
	}
	
	@Test(priority=5)
	public void Forgot_Password_4_B() throws IOException
	{
		Log.startTestCase("TC 4B - Forgot Password");
		login.logintapplication("123","22131");	
		String actual_err=GetTextFun(login.errormessage(),"Error Message");
		assertFun(actual_err,login.expected_errormsg);
		Log.info("TC 4B successfully completed");
		Log.endTestCase("TC 4B - Forgot Password");
	}

	@AfterMethod
	public void teardown() throws IOException {
		 takescreenshot(driver);
		 driver.close();

	}

}
