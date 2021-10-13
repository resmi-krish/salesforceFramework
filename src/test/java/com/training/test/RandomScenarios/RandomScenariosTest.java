package com.training.test.RandomScenarios;

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
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;
import com.training.pages.RandomScenariosPage;
import com.training.utilities.CommonUtilities;

public class RandomScenariosTest extends BaseTest {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
	OpportunityPage opportunity;
	LeadsPage leads;
	ContactsPage contacts;
	RandomScenariosPage random;
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
		contacts=new ContactsPage(driver);
		random=new RandomScenariosPage(driver);
		driver.manage().window().maximize();
		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);	
		login.implicitwait();
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	@Test(priority=1)
	public void nameDisplay()
	{
		Log.startTestCase("TC 33 - Verify first name and last name");
		random.homeTabClick();
		String actualName=GetTextFun(random.usrName(),"Name");
		assertFun(actualName,random.expectedName);
		random.namedisplayVerification();
		Log.endTestCase("TC 33 - Verify first name and last name");
	}
	
	
	@Test(priority=2)
	public void editLastNameVerify()
	{
		Log.startTestCase("TC 34 - Verfiy edited last name is updated");
		random.homeTabClick();
		random.namedisplayVerification();
		home.editProfile();
		home.Lname_new="Abcd";
		home.aboutTab();
		
		String actprofName=GetTextFun(random.prfName(),"Profile Name");
		Log.info("The updated profile Name:" +actprofName);
		String Actua_Name=GetTextFun(home.ProfName(),"LastName");
		assertFun(Actua_Name,random.expectedprofileName);
		
		random.returnHome();
		String actualName=GetTextFun(random.usrName(),"Name");
		assertFun(actualName,random.expectedprofileName);
		Log.endTestCase("TC 34 - Verfiy edited last name is updated");
	}
	
	
	@Test(priority=3)
	public void tabCustomize()
	{
		Log.startTestCase("TC 35 - Verify Tab Customization");
		random.custTabs();
		login.MenuClick();
		login.logout();
		login.logintapplication("resmi@tekarch.com","test@123");
		
		String S=GetTextFun(random.tabDetails(),"Tab");
		String[] sr=S.split("(?=[A-Z])");
		for(int i=0;i<sr.length;i++)
		{
			if(sr[i].equals("Chatter"))
			  {
			    Log.info("Chatter Tab is not deleted");
			  }
		
		}	
		Log.endTestCase("TC 35 - Verify Tab Customization");
	 }
	
	
	@Test(priority=4)
	public void blockCalendar() throws InterruptedException
	{
		Log.startTestCase("TC 36 - Blocking Calendar");
		random.homeTabClick();
		random.calendarBlock();
		String actualcalVaild=GetTextFun(random.calendarValid(),"calendar Valid");
		Log.info("Calender User Name "+actualcalVaild);
		Log.endTestCase("TC 36 - Blocking Calendar");
	}
	
	@Test(priority=5)
	public void blockWeeklyRecurrance()
	{
		Log.startTestCase("TC 37 - Weekly Occurance");
		random.homeTabClick();
		random.weeklyrecurrance();
		random.monthvw();
		String actualcalVald=GetTextFun(random.calendarValid(),"calendar Valid");
		Log.info("Calender User Name: "+actualcalVald);
		Log.endTestCase("TC 37 - Weekly Occurance");
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		 takescreenshot(driver);
		 driver.close();

	}

}
