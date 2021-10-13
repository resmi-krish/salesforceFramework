package com.training.test.Contacts;

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
import com.training.utilities.CommonUtilities;

public class ContactsTest extends BaseTest {
	
	WebDriver driver;
	LoginPage login;
	HomePage home;
	AccountPage account;
	OpportunityPage opportunity;
	LeadsPage leads;
	ContactsPage contacts;
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
		driver.manage().window().maximize();
		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);	
		login.implicitwait();
		DOMConfigurator.configure("log4j.xml");
	}
	
	
	@Test(priority=1)
	public void createNewContact()
	{
		Log.startTestCase("TC 25 - Create New Contact");
		contacts.contactclk();
		contacts.newcontact();
		String actualcontactName=GetTextFun(contacts.newContactValid(),"Name Valid");
		assertFun(actualcontactName,contacts.expectedcontactName);
		Log.endTestCase("TC 25 - Create New Contact");
	}
	
	
	@Test(priority=2)
	public void createView()
	{
		Log.startTestCase("TC 26 - Create New View");
		contacts.contactclk();
		contacts.createNewView();
		Select sl=new Select(contacts.selVal());
		WebElement vw=sl.getFirstSelectedOption();
		if((vw.getText()).equals("Test View"))
		{
			Log.info("The View Selected is correct");
		}	
		Log.endTestCase("TC 26 - Create New View");
	}
	
	
	@Test(priority=3)
	public void recentContact()
	{
		Log.startTestCase("TC 27 - Recently Created Contact");
		contacts.contactclk();
		contacts.recentCont();
		Log.endTestCase("TC 27 - Recently Created Contact");
	}
	
	
	@Test(priority=4)
	public void myContactView()
	{
		Log.startTestCase("TC 28 - My Contacts View");
		contacts.contactclk();
		contacts.contactView();
		Log.endTestCase("TC 28 - My Contacts View");
	}
	
	
	@Test(priority=5)
	public void viewContact()
	{
		Log.startTestCase("TC 29 - View a contact in contact Page");
		contacts.contactclk();
		contacts.viewonecontact();
		Log.endTestCase("TC 29 - View a contact in contact Page");
	}
	
	@Test(priority=6)
	public void errorMessage()
	{
		Log.startTestCase("TC 30 - Check Error Message");
		contacts.contactclk();
		contacts.viewErrorMsg();
		String actualerrormsg=GetTextFun(contacts.errorMessage(),"Error Message");
		assertFun(actualerrormsg,contacts.expectederrormsg);
		Log.endTestCase("TC 30 - Check Error Message");
	}
	
	
	@Test(priority=7)
	public void checkCancelBtn()
	{
		Log.startTestCase("TC 31 - Check Cancel Button");
		contacts.contactclk();
		contacts.cancelViewCreate();
		
		Select s1=new Select(contacts.selVal());
		List<WebElement> l=s1.getOptions();
		for(int i=0;i<l.size();i++)
		{
		  if((l.get(i).getText())!=("ABCD"))
		    {
			  Log.info("The view is not created");
		    }	
		  else
		    {
			  Log.info("The view is created");
		    }
		}
		Log.endTestCase("TC 31 - Check Cancel Button");
	 }
	
	@Test(priority=8)
	public void checkSaveNewBtn()
	{
		Log.startTestCase("TC 32 - Check Save and New Button");
		contacts.contactclk();
		contacts.chekNewSaveBtn();
		String saveBtnVald1=GetTextFun(contacts.cntctEdt(),"Validation");
		String saveBtnVald2=GetTextFun(contacts.newCnt(),"Validation");
		String actualnwcntValid=saveBtnVald1+" "+saveBtnVald2;
		assertFun(actualnwcntValid,contacts.expectednwcntValid);
		Log.endTestCase("TC 32 - Check Save and New Button");
	}
	
	@AfterMethod
	 public void teardown() throws IOException {
		 takescreenshot(driver);
		 driver.close();

	}

}
