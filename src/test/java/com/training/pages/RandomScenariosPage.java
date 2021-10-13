package com.training.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class RandomScenariosPage extends BasePage{

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='Home Tab']")
	WebElement homeTab;
	
	@FindBy(xpath = "//h1/a")
	WebElement userName;
	
	@FindBy(id = "tryLexDialogX")
	WebElement closePrmt;
	
	@FindBy(id = "tailBreadcrumbNode")
	WebElement profileName;
	
	@FindBy(xpath = "//img[@title='All Tabs']")
	WebElement allTab;
	
	@FindBy(xpath = "//input[@title='Customize My Tabs']")
	WebElement custMyTabBtn;
	
	@FindBy(id = "duel_select_1")
	WebElement seleTab;
	
	@FindBy(xpath = "//img[@title='Remove']")
	WebElement rmvBtn;
	
	@FindBy(xpath = "//input[@title='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//ul[@id='tabBar']")
	WebElement tabBar;
	
	@FindBy(xpath = "//span[@class='pageDescription']/a")
	WebElement curntDate;
	
	@FindBy(xpath = "//div[@id='p:f:j_id25:j_id61:28:j_id64']/a")
	WebElement timeLink;
	
	@FindBy(xpath="//div[@id='p:f:j_id25:j_id61:20:j_id64']/a")
	WebElement timeLnk;
	
	@FindBy(xpath = "//img[@title='Subject Combo (New Window)']")
	//@FindBy(xpath = "//div[@class='requiredInput']/a")
	WebElement subCombo;
	
	@FindBy(id = "evt5")
	WebElement subj;
	
	@FindBy(xpath = "//td[@id='topButtonRow']/input[@name='cancel']")
	WebElement canc;
	
	@FindBy(xpath = "//a[@href='javascript:pickValue(4);']")
	WebElement otherOption;
	
	@FindBy(id = "EndDateTime_time")
	WebElement endTime;
	
	@FindBy(xpath = "//div[@id='timePickerItem_42']")
	WebElement specTime;
	
	@FindBy(xpath = "//div[@id='timePickerItem_38']")                     
	WebElement spTime;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement calSave;
	
	@FindBy(xpath = "//input[@id='IsRecurrence']")
	WebElement recurr;
	
	@FindBy(xpath = "//input[@id='rectypeftw']")
	WebElement weekR;
	
	@FindBy(xpath = "//input[@id='RecurrenceEndDateOnly']")
	WebElement recEndDate;
	
	@FindBy(xpath = "//a/img[@class='monthViewIcon']")
	WebElement mntView;
	
	@FindBy(xpath = "//div/h1[@class='pageType']")
	WebElement calValid;
	
	public String expectedName="Resmi Krishna Kumar";
	public String expectedprofileName="Resmi Abcd";
	
	public WebElement usrName()
	{
	    return userName;
	}
	
	public WebElement prfName()
	{
		return profileName;
	}
	
	public WebElement tabDetails()
	{
		return tabBar;
	}
	
	public WebElement calendarValid()
	{
		return calValid;
	}
	
	public void homeTabClick()
	{
		ClickObj(homeTab,"Home");
		ClickObj(closePrmt,"Close");
	}
	
	public void returnHome()
	{
		ClickObj(homeTab,"Home");
	}
	
	public void namedisplayVerification()
	{
		ClickObj(userName,"Name");
	}
	
	public void custTabs()
	{
		ClickObj(allTab,"All Tab");
		ClickObj(custMyTabBtn,"Customize my Tab");
		selectFunction(seleTab,"Chatter");
		ClickObj(rmvBtn,"Remove");
		ClickObj(saveBtn,"Save");		
	}
	
	public void calendarBlock() throws InterruptedException
	{
		ClickObj(curntDate,"Date");
		ClickObj(timeLink,"Time");
		waitforElement(canc);
		ClickObj(subCombo,"Sub Combo");
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		ClickObj(otherOption,"Other");
		driver.switchTo().window(currentHandle);
		ClickObj(endTime,"End Time");
		ClickObj(specTime,"9 PM");
		ClickObj(calSave,"Save");		
	}
	
	public void weeklyrecurrance()
	{
		ClickObj(curntDate,"Date");
		ClickObj(timeLnk,"Time");
		ClickObj(subCombo,"Sub Combo");
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		ClickObj(otherOption,"Other");
		driver.switchTo().window(currentHandle);
		ClickObj(endTime,"End Time");
		ClickObj(spTime,"7 PM");
		SelectCheckBox(recurr,"Recurring Events");
		ClickObj(weekR,"Weekly Radio Btn");
		ClickObj(recEndDate,"End Date");
		String dt=dateadd7Function();
		EnterText(recEndDate,dt);
		ClickObj(calSave,"Save");	
	}
	
	public void monthvw()
	{
		ClickObj(mntView,"Month View");
	}

}
