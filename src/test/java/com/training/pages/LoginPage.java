package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Uname;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//div[@id='error']")
	WebElement errormessage;
	
	@FindBy(xpath = "//*[@id='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//*[@id='rememberUn']")
	WebElement remember;
	
	@FindBy(xpath = "//*[@id='forgot_password_link']")
	WebElement Fpwd;
	
	@FindBy(xpath = ".//*[@id='un']")
	WebElement Fname;
	
	@FindBy(xpath = "//div[@id='error']")
	WebElement Errmsg;
	
	@FindBy(id = "userNav-arrow")
	WebElement MenuDropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement LogOut;
	
	@FindBy(id = "continue")
	WebElement Continue;
	
	
	public String expectedvalue="Please enter your password.";
	public String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
	public String expected_forgotpassword= "Forgot Your Password | Salesforce";
	public String expected_username= "resmi@tekarch.com";
	public String expected_message= "Check Your Email | Salesforce";
	public String expected_errormsg= "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	
	
	public WebElement enterintoUsername()
	{
		return Uname; 
	}
	
	public WebElement errormessage()
	{
		return Errmsg;
	}
	
	public void logintapplication(String strusername, String strpassword) 
	{
		EnterText(Uname,strusername);
		EnterText(pwd,strpassword);
		ClickObj(loginbtn,"login");
	}
	
	public void checkrememberme(String strusername, String strpassword)
	{
		EnterText(Uname,strusername);
		EnterText(pwd,strpassword);
		SelectCheckBox(remember,"RememberMe");	
		ClickObj(loginbtn,"login");
	}
	
	public void MenuClick()
	{
		ClickObj(MenuDropDown,"user drop down menu");			
	}
	
	public void logout()
	{
		ClickObj(LogOut,"logout");
	}
	
	public void forgotPassword(String usrname)
	{
		EnterText(Uname,usrname);		
		ClickObj(Fpwd,"forgot password");	
	}
	
	public void forgotpwdentervalue(String Fullname)
	{
		EnterText(Fname,Fullname);	
		ClickObj(Continue,"continue");	
	}

}