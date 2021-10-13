package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

import net.bytebuddy.asm.Advice.Enter;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='Leads Tab']")
	WebElement leadsLink;
	
	@FindBy(xpath = "//h1[@class='pageType']")
	WebElement pagedsplay;
	
	@FindBy(xpath = "//h2[normalize-space()='Home']")
	WebElement pagedisplay;
	
	@FindBy(id = "tryLexDialogX")
	WebElement closePrmt;
	
	@FindBy(name = "fcf")
	WebElement leadDropdown;
	
	@FindBy(id = "userNav-arrow")
	WebElement downArrow;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//input[@title='Go!']")
	WebElement goBtn;
	
	@FindBy(xpath = "//input[@title='New']")
	WebElement newBtn;
	
	@FindBy(id = "name_lastlea2")
	WebElement lastName;
	
	@FindBy(id = "lea3")
	WebElement cmpnyName;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement saveLeadBtn;
	
	@FindBy(className = "topName")
	WebElement saveValidate;
	
	
	public String expectedValid="Leads Home";
	public String expectedleadName="ABCD";
	
	public WebElement leadvalidate1()
	{
		return pagedsplay;
	}
	
	public WebElement leadvalidate2()
	{
		return pagedisplay;
	}
	
	public WebElement dropDownValid()
	{
		return leadDropdown;
	}
	
	public WebElement saveValid()
	{
		return saveValidate;
	}
	
	public void leadsLnk()
	{
		ClickObj(leadsLink,"Leads");
		ClickObj(closePrmt,"Close");
	}
	
	public void leadsReturn()
	{
		ClickObj(leadsLink,"Leads");
	}
	
	public void defaultView()
	{
		selectFunction(leadDropdown,"Today's Leads");
		ClickObj(downArrow,"Drop Down");
		ClickObj(logout,"Logout");	
	}
	
	public void defaultGoview()
	{
		ClickObj(goBtn,"Go");
	}
	
	public void todayLeadWork()
	{
		selectFunction(leadDropdown,"Today's Leads");
		ClickObj(goBtn,"Go");
	}
	
	public void newBtnLead()
	{
		ClickObj(newBtn,"New");
		EnterText(lastName,"ABCD");
		EnterText(cmpnyName,"ABCD");
		ClickObj(saveLeadBtn,"Save");
	}
	
	

}
