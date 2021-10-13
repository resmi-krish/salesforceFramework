package com.training.test.Leads;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.AccountPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.utilities.CommonUtilities;

public class LeadsTest extends BaseTest {
	
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
	OpportunityPage opportunity;
	LeadsPage leads;
	CommonUtilities common = new CommonUtilities();
	
	@BeforeMethod
	public void beforeTest() throws IOException, InterruptedException 
	{
		driver = getDriver();
		String Url = common.getApplicationProperty("url");
		driver.get(Url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		account=new AccountPage(driver);
		opportunity=new OpportunityPage(driver);
		leads=new LeadsPage(driver);
		driver.manage().window().maximize();
		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);	
		login.implicitwait();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Test(priority=1)
	public void leadLink()
	{
		Log.startTestCase("TC 20 - Leads Tab Link");
		leads.leadsLnk();
		String leadVlidate1=GetTextFun(leads.leadvalidate1(),"Validate");
		String leadVlidate2=GetTextFun(leads.leadvalidate2(),"Validate");
		String finalValidate=leadVlidate1+" "+leadVlidate2;
		assertFun(finalValidate,leads.expectedValid);
		Log.endTestCase("TC 20 - Leads Tab Link");
	}
	
	@Test(priority=2)
	public void leadDropdown()
	{
		Log.startTestCase("TC 21 Leads Drop Down");
		leads.leadsLnk();
		
		Select selet=new Select(leads.dropDownValid());
		System.out.println("The drop down values are:");
		List<WebElement> lst=selet.getOptions();
		for(int i=0;i<lst.size();i++)
		{
		   Log.info(lst.get(i).getText());
		}
		Log.endTestCase("TC 21 Leads Drop Down");
	}
	
	@Test(priority=3)
	public void leaddefaultView()
	{
		Log.startTestCase("TC 22 - Default View");
		leads.leadsLnk();
		leads.defaultView();
		login.logintapplication("resmi@tekarch.com","test@123");
		leads.leadsReturn();
		leads.defaultGoview();
		
		Select s=new Select(leads.dropDownValid());
		WebElement selOption=s.getFirstSelectedOption();
		if(selOption.getText().equals("Today's Leads"))
		  { 
			Log.info("The selected option is Today's lead");
		  }
		Log.endTestCase("TC 22 - Default View");
	}
	
	@Test(priority=4)
	public void todayLead()
	{
		Log.startTestCase("TC 23 Today's Lead Work");
		leads.leadsLnk();
		leads.todayLeadWork();
		Select sl=new Select(leads.dropDownValid());
		WebElement selOption=sl.getFirstSelectedOption();
		if(selOption.getText().equals("Today's Leads"))
		  { 
			Log.info("Today's Lead is displayed");
		  }
		Log.endTestCase("TC 23 Today's Lead Work");
	}
	
	
	@Test(priority=5)
	public void newBtnCheck()
	{
		Log.startTestCase("TC 24 - New Button on Leads Page");
		leads.leadsLnk();
		leads.newBtnLead();
		String actualLeadName=GetTextFun(leads.saveValid(),"Validation");
		assertFun(actualLeadName,leads.expectedleadName);
		Log.endTestCase("TC 24 - New Button on Leads Page");
	}
	
	 @AfterMethod
 	 public void teardown() throws IOException {
 		 takescreenshot(driver);
 		 driver.close();

 	}

}
