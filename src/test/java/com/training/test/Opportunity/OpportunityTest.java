package com.training.test.Opportunity;

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
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.utilities.CommonUtilities;

public class OpportunityTest extends BaseTest 
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
	OpportunityPage opportunity;
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
		driver.manage().window().maximize();
		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);	
		login.implicitwait();
		DOMConfigurator.configure("log4j.xml");

	}
	
	
	@Test(priority=1)
	public void opportunitiesDropdown()
	{
		Log.startTestCase("TC 15 - Opportunity drop down");
		opportunity.opportunityDrpdown();
		Select sel=new Select(opportunity.opportunityT());
		List<WebElement> li=sel.getOptions();
		System.out.println("The drop down:");
		for (int i=0;i<li.size();i++)
		{
			System.out.println(li.get(i).getText());
		}	
		Log.endTestCase("TC 15 - Opportunity drop down");
	}
  
	@Test(priority=2)
	public void newOpportunity()
	{
		Log.startTestCase("TC 16 - New Opportunity");
		opportunity.opportunityClk();
		opportunity.newopprtunity();
		String actualTt=GetTextFun(opportunity.opValidate(),"Validation");
		assertFun(actualTt,opportunity.expectedTt);
		Log.endTestCase("TC 16 - New Opportunity");
	}
	
	
	@Test(priority=3)
	public void opportunityPipeline()
	{
		Log.startTestCase("TC 17 - Test Opportunity Pipeline Report");
		opportunity.opportunityClk();
		opportunity.opportunityPiplinReport();
		String actualRpt=GetTextFun(opportunity.rptValid(),"Report Validation");
		assertFun(actualRpt,opportunity.expectedRpt);
		Log.endTestCase("TC 17 - Test Opportunity Pipeline Report");
	}
	
	@Test(priority=4)
	public void stuckOpportunityRpt()
	{
		Log.startTestCase("TC 18 - Test Stuck Opportunity Report");
		opportunity.opportunityClk();
		opportunity.stuckOpportunity();
		String actualStkRpt=GetTextFun(opportunity.stkRptValid(),"Stuck Report");
		assertFun(actualStkRpt,opportunity.expectedStkRpt);
		Log.endTestCase("TC 18 - Test Stuck Opportunity Report");
	}
	
	@Test(priority=5)
	public void quarterlySummaryRpt()
	{
		Log.startTestCase("TC 19 - Quarterly Summary Report");
		opportunity.opportunityClk();
		opportunity.quarterlySummary();
		String actualRptStatus1=GetTextFun(opportunity.rptGeneration(),"Report Status 1");
		Log.info("The first report generation Status:" +actualRptStatus1);
		opportunity.quarterlySumry();
		String actualRptStatus2=GetTextFun(opportunity.rptGeneration(),"Report Status 2");
		Log.info("The second report generation Status:" +actualRptStatus2);
		Log.endTestCase("TC 19 - Quarterly Summary Report");
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		 takescreenshot(driver);
		 driver.close();
	}
}
