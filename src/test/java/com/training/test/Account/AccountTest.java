package com.training.test.Account;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
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
import com.training.utilities.CommonUtilities;

public class AccountTest extends BaseTest 
{
     LoginPage login;
     HomePage home;
     AccountPage account;
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
 		driver.manage().window().maximize();
 		String Username = common.getApplicationProperty("Uname");	
		String Password = common.getApplicationProperty("pwd");
		login.logintapplication(Username,Password);	
		login.implicitwait();
		DOMConfigurator.configure("log4j.xml");
 	}
     
     @Test(priority=1)
     public void createAccount()
     {
    	 Log.startTestCase("TC 10 - Create Account");
    	 account.accountLink();
    	 account.newAccount();
    	 String actualDisplayName=GetTextFun(account.nameValidation(),"Name");
    	 assertFun(actualDisplayName,account.expectedDisplayName);
    	 Log.endTestCase("TC 10 - Create Account");
     }
     
     
     @Test(priority=2)
     public void createNewView()
     
     {
    	 Log.startTestCase("TC 11 - Create New View");
    	 account.accountLink();
    	 account.newView();
    	 Select sel=new Select(account.viewValidate());
    	 List <WebElement> l=sel.getOptions();
    	 for(int i=0;i<l.size();i++)
    	 {
    		 if(l.get(i).getText().equals(account.selectVal))
    		 {
    			 System.out.println("The new view added");
    		 }
    	 }
    	 Log.endTestCase("TC 11 - Create New View");
     }
     
     
     @Test(priority=3)
     public void editViewOption()
     {
    	 Log.startTestCase("TC 12 - Edit View Option");
    	 account.accountLink();
    	 account.editView();
    	 String actualDetails=GetTextFun(account.lastActivityTab(),"Last Activity");
    	 assertFun(actualDetails,account.actTab);	
    	 Log.endTestCase("TC 12 - Edit View Option");
     }
     
     
     @Test(priority=4)
     public void mergeAccountOption()
     {
    	 Log.startTestCase("TC 13 - Merge Accounts");
    	 account.accountLink();
    	 account.mergeAccount();
    	 Log.endTestCase("TC 13 - Merge Accounts");
     }
     
     
     @Test(priority=5)
     public void createAccountReport() throws InterruptedException
     {
    	 Log.startTestCase("TC 14 - Create Annual Report");
    	 account.accountLink();
    	 account.createReport();
    	 String rptStatus=GetTextFun(account.reportGenStat(),"Report");
    	 System.out.println("Report Generation Status is :"+rptStatus);
    	 Log.endTestCase("TC 14 - Create Annual Report");
     }
     
     @AfterMethod
 	 public void teardown() throws IOException {
 		takescreenshot(driver);
 		driver.close();

 	}
     
	
}
