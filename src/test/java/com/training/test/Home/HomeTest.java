package com.training.test.Home;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest{
	
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
		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);		
		login.implicitwait();
		driver.manage().window().maximize();
		DOMConfigurator.configure("log4j.xml");

	}
	
	@Test(priority=1)
	public void username_dropdown() throws IOException, InterruptedException
	{
		Log.startTestCase("TC 05 - Select User Menu");	
		login.MenuClick();
		String actual_Text=GetTextFun(home.userNav(),"User Name");
		String actual_txt=actual_Text.replaceAll("\n", " ");
		arrayassert(actual_txt, home.expected_Txt);
		Log.info("TC 05 Successfully completed");
		Log.endTestCase("TC 05 - Select User Menu");
	}
	
	@Test(priority=2)
	public void MyProfile_option()
	{
		Log.startTestCase("TC 06 - My profile option");
		login.MenuClick();
		home.myProfileclick();
		
		home.editProfile();
		Log.info("Edit profile completed");
		
		home.aboutTab();
		String Actual_Name=GetTextFun(home.ProfName(),"LastName");
		assertFun(Actual_Name, home.expected_Name);
		Log.info("About Tab completed");
		
		home.postLinkclick();
		String actual_enteredtext=GetTextFun(home.ShareValid(),"Get Updated Text");
		assertFun(actual_enteredtext, home.Enter_text);
		Log.info("Posted text");
		
		home.fileLinkclick();
		String file_Text=GetTextFun(home.fileShareValid(),"Get updated file details");
		assertFun(file_Text, home.expectedfileText);
		Log.info("File upload completed");
		
		home.addphotocrop();
		Log.info("Add photo and crop completed");
		Log.endTestCase("TC 06 - My profile option");
	}
	
	
	@Test(priority=3)
	public void MySetting_Option() throws InterruptedException
	{
		Log.startTestCase("TC 07 - My Settings");
		login.MenuClick();
		home.mySettingsclick();
		
		home.personalLink();
		String Last_login=GetTextFun(home.latestLoginValidate(),"Latest login");
		Log.info("TC07 - The latest login:" +Last_login);
		
		home.displayLayoutLink();
		String report_salesforce=GetTextFun(home.reportSalesForce(),"Main Page Report");
		assertFun(report_salesforce,home.expected_report);
		Log.info("Display layout Tab completed");
		
		home.emailLink();
		String email_valid=GetTextFun(home.emailMessage(),"Email message");
		assertFun(email_valid,home.email_message);
		Log.info("Email link tab completed");
		
		String parentWindow=home.storeParentWindow();
		home.calendarReminder();
		String urlDetails=home.getUrl();
    	System.out.println("The URL is :"+urlDetails);
		home.ClickObj(home.dismissAll(),"Dismiss All");
		home.switchbackToParent(parentWindow);
		Log.info("TC 07 successfully completed");
		Log.endTestCase("TC 07 - My Settings");
		
	}

	@Test(priority=4)
	public void developerConsoleOption()
	{
		Log.startTestCase("TC 08 - Developers Console option");
		login.MenuClick();
		String homeWindow=home.storeParentWindow();
		home.developerConsole();
		String actualdevTitle=getTitle();
		assertFun(actualdevTitle, home.expecteddevTitle);
		home.currentWindowClose();
		home.switchbackToParent(homeWindow);
		Log.info("TC 08 successfully completed");
		Log.endTestCase("TC 08 - Developers Console option");
	}
	
	@Test(priority=5)
	public void logoutOption()
	{
		Log.startTestCase("TC 09 - Logout");
		login.MenuClick();
		login.logout();
		Log.endTestCase("TC 09 - Logout");
	}
	
	
	@AfterMethod
	public void teardown() throws IOException {
		 takescreenshot(driver);
		 driver.close();

	}
}
