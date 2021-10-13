package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='Accounts Tab']")
	WebElement accountTab;
	
	@FindBy(id = "tryLexDialogX")
	WebElement closePromt;
	
	@FindBy(name = "new")
	WebElement newBtn;
	
	@FindBy(id = "acc2")
	WebElement accountName;
	
	@FindBy(id = "acc6")
	WebElement selType;
	
	@FindBy(id = "00N5f000006ewXo")
	WebElement selPriority;
	
	@FindBy(name = "save")
	WebElement accntSaveBtn;
	
	@FindBy(className = "topName")
	WebElement nameDisplay;
	
	@FindBy(linkText = "Create New View")
	WebElement newView;
	
	@FindBy(id = "fname")
	WebElement viewName;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement viewSaveBtn;
	
	@FindBy(name = "fcf")
	WebElement viewDisplay;
	
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement editLink;
	
	@FindBy(id = "fname")
	WebElement vwName;
	
	@FindBy(id = "fcol1")
	WebElement fieldName;
	
	@FindBy(id = "fop1")
	WebElement contain;
	
	@FindBy(id = "fval1")
	WebElement filterText;
	
	@FindBy(id = "colselector_select_0")
	WebElement lastActivity;
	
	@FindBy(id = "colselector_select_0_right")
	WebElement addBtn;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement editSaveBtn;
	
	@FindBy(xpath = "//div[@title='Last Activity']")
	WebElement lastActTab;
	
	@FindBy(linkText = "Merge Accounts")
	WebElement mergeAccnt;
	
	@FindBy(id = "srch")
	WebElement accntNameSearch;
	
	@FindBy(name = "srchbutton")
	WebElement findBtn;
	
	@FindBy(id = "cid0")
	WebElement chkBox1;
	
	@FindBy(id = "cid1")
	WebElement chkBox2;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Next']")
	WebElement nxtBtn;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Merge']")
	WebElement mergeBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Accounts with last activity > 30 days']")
	WebElement accntActivity;
	
	@FindBy(id = "ext-gen148")
	WebElement dropDown;
	
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	WebElement createdDate;
	
	@FindBy(name = "startDate")
	WebElement startDate;
	
	@FindBy(name = "endDate")
	WebElement endDate;
	
	@FindBy(id = "ext-gen49")
	WebElement saveReportBtn;
	
	@FindBy(name = "reportName")
	WebElement reportName;
	
	@FindBy(xpath = "//input[@id='saveReportDlg_DeveloperName']")
	WebElement uniqueReportName;
	
	@FindBy(xpath = "//table[@id='dlgSaveAndRun']")
	WebElement saveRunBtn;
	
	@FindBy(id = "status")
	WebElement reportStatus;
	
	
	public String expectedDisplayName="Resmi Krish";
	public String selectVal="August Training";
	public String actTab="Last Activity";
	
	public void closePrmt()
	{
		ClickObj(closePromt,"Close Prompt");
	}
	
	public WebElement nameValidation()
	{
		return nameDisplay;
	}
	
	public WebElement viewValidate()
	{
		return viewDisplay;
	}
	
	public WebElement lastActivityTab()
	{
		return lastActTab;
	}
	
	public WebElement reportGenStat()
	{
		return reportStatus;
	}
	
	public void accountLink()
	{
		ClickObj(accountTab,"Account Tab");
		ClickObj(closePromt,"Close Prompt");
	}
	
	public void newAccount()
	{
		ClickObj(newBtn,"New Button");
		EnterText(accountName,"Resmi Krish");
		selectFunction(selType,"Technology Partner");
		selectFunction(selPriority,"High");
		ClickObj(accntSaveBtn,"Save");	
	}
	
	public void newView()
	{
		ClickObj(newView,"New View");
		EnterText(viewName,"August Training");
		ClickObj(viewSaveBtn,"Save");
	}
	
	public void editView()
	{
		selectFunction(viewDisplay,"August Training");
		ClickObj(editLink,"Edit");
		EnterText(vwName,"New View Name");
		selectFunction(fieldName,"Account Name");
		selectFunction(contain,"contains");
		EnterText(filterText,"Krish");	
		selectFunction(lastActivity,"Last Activity");
		ClickObj(addBtn,"Add");
		ClickObj(editSaveBtn,"Save");		
	}
	
	public void mergeAccount()
	{
		ClickObj(mergeAccnt,"Merge Account");
		EnterText(accntNameSearch,"Resmi");
		ClickObj(findBtn,"Find Account");
		SelectCheckBox(chkBox1,"Check Box1");
		SelectCheckBox(chkBox2,"Check Box2");
		ClickObj(nxtBtn,"Next");
		ClickObj(mergeBtn,"Merge");
		alertAccept();	
	}
	
	public void createReport() throws InterruptedException
	{
		ClickObj(accntActivity,"Account Activity>30");
		ClickObj(dropDown,"Drop Down");
		ClickObj(createdDate,"Created date");
		String date=dateFunction();
		clearTxtBox(startDate);
		EnterText(startDate,date);
		clearTxtBox(endDate);
		EnterText(endDate,date);
		ClickObj(saveReportBtn,"Save");
		EnterText(reportName,"New Report");
		ClickObj(uniqueReportName,"Unique Report Name");
		clearTxtBox(uniqueReportName);
	    EnterText(uniqueReportName,"auto_Report");
    	Thread.sleep(5000);
		waitforElementToClick(saveRunBtn);
		ClickObj(saveRunBtn,"Save");
	}

}
