package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

import net.bytebuddy.asm.Advice.Enter;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='Contacts Tab']")
	WebElement contactsTab;
	
	@FindBy(id = "tryLexDialogX")
	WebElement closePrmt;
	
	@FindBy(xpath = "//input[@title='New']")
	WebElement newContactBtn;
	
	@FindBy(id = "name_lastcon2")
	WebElement lstName;
	
	@FindBy(id = "con4")
	WebElement accntName;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement saveContactBtn;
	
	@FindBy(className = "topName")
	WebElement contactValid;
	
	@FindBy(linkText = "Create New View")
	WebElement createViewBtn;
	
	@FindBy(xpath = "//input[@id='fname']")
	WebElement viewName;
	
	@FindBy(xpath = "//input[@id='devname']")
	WebElement uniqueName;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement saveViewBtn;
	
	@FindBy(name = "fcf")
	WebElement seleValid;
	
	@FindBy(id = "hotlist_mode")
	WebElement selRecent;
	
	@FindBy(xpath = "//input[@title='Go!']")
	WebElement goContBtn;
	
	@FindBy(xpath = "//tr[2]/th[1]/a")
	WebElement cntctFind;
	
	@FindBy(xpath = "//div[@class='requiredInput']//div[@class='errorMsg']")
	WebElement errorMsg;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[2]")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save & New']")
	WebElement savenewBtn;
	
	@FindBy(xpath = "//h1[@class='pageType']")
	WebElement contactEdit;
	
	@FindBy(xpath = "//h2[normalize-space()='New Contact']")
	WebElement nwContact;
	
	public String expectedcontactName="John";
	public String expectederrormsg="Error: You must enter a value";
	public String expectednwcntValid="Contact Edit New Contact";
	
	public WebElement newContactValid()
	{
		return contactValid;
	}
	
	public WebElement selVal()
	{
		return seleValid;
	}
	
	public WebElement errorMessage()
	{
		return errorMsg;
	}
	
	public WebElement cntctEdt()
	{
		return contactEdit;
	}
	
	public WebElement newCnt()
	{
		return nwContact;
	}
	
	public void contactclk()
	{
		ClickObj(contactsTab,"Contact");
		ClickObj(closePrmt,"Close");
	}

	public void newcontact()
	{
		ClickObj(newContactBtn,"New");
		EnterText(lstName,"John");
		EnterText(accntName,"Resmi Kris");
		ClickObj(saveContactBtn,"Save");
	}
	
	public void createNewView()
	{
		ClickObj(createViewBtn,"Create View");
		EnterText(viewName,"Test View");
		ClickObj(uniqueName,"View Unique Name");
		ClickObj(saveViewBtn,"save");
	}
	
	public void recentCont()
	{
		selectFunction(selRecent,"Recently Created");
	}
	
	public void contactView()
	{
		selectFunction(seleValid,"My Contacts");
		//ClickObj(goContBtn,"Go");
	}
	
	public void viewonecontact()
	{
		ClickObj(cntctFind,"First Contact");
	}
	
	public void viewErrorMsg()
	{
		ClickObj(createViewBtn,"Create View");
		ClickObj(uniqueName,"View Unique Name");
		EnterText(uniqueName,"EFGH");
		ClickObj(saveViewBtn,"save");
	}
	
	public void cancelViewCreate()
	{
		ClickObj(createViewBtn,"Create View");
		EnterText(viewName,"ABCD");
		ClickObj(uniqueName,"View Unique Name");
		clearTxtBox(uniqueName);
		EnterText(uniqueName,"EFGH");
		ClickObj(cancelBtn,"Cancel");
	}
	
	public void chekNewSaveBtn()
	{
		ClickObj(newContactBtn,"New");
		EnterText(lstName,"Indian");
		EnterText(accntName,"Resmi Kris");
		ClickObj(savenewBtn,"Save New");
	}
}
