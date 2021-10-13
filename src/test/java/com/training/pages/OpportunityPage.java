package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage{

	public OpportunityPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[@title='Opportunities Tab']")
	WebElement opportunityTab;
	
	@FindBy(id = "fcf")
	WebElement oppDropdown;
	
	@FindBy(id = "tryLexDialogX")
	WebElement closePrmt;
	
	@FindBy(xpath = "//input[@title='New']")
	WebElement newOppr;
	
	@FindBy(id = "opp3")
	WebElement opporName;
	
	@FindBy(id = "opp4")
	WebElement accntName;
	
	@FindBy(id = "opp9")
	WebElement closeDate;
	
	@FindBy(id = "opp11")
	WebElement stage;
	
	@FindBy(id = "opp12")
	WebElement probability;
	
	@FindBy(id = "opp6")
	WebElement leadSource;
	
	@FindBy(id = "opp17")
	WebElement primaryCampaign;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement saveOBtn;
	
	@FindBy(className = "pageDescription")
	WebElement oppValidate;
	
	@FindBy(linkText = "Opportunity Pipeline")
	WebElement pipelineLink;
	
	@FindBy(xpath = "//h1[normalize-space()='Opportunity Pipeline']")
	WebElement reportValid;
	
	@FindBy(linkText = "Stuck Opportunities")
	WebElement stkOpportunity;
	
	@FindBy(xpath = "//h1[normalize-space()='Stuck Opportunities']")
	WebElement stkReportValid;
	
	@FindBy(id = "quarter_q")
	WebElement interval;
	
	@FindBy(id = "open")
	WebElement inclde;
	
	@FindBy(xpath = "//input[@title='Run Report']")
	WebElement runReportBtn;
	
	@FindBy(id = "status")
	WebElement rptGenStatus;
	
	@FindBy(linkText = "Opportunities")
	WebElement opporLink;
	
	public String expectedTt="Salesforce";
	public String expectedRpt="Opportunity Pipeline";
	public String expectedStkRpt="Stuck Opportunities";
	
	public WebElement opportunityT()
	{
		return oppDropdown;
	}
	
	public WebElement opValidate()
	{
		return oppValidate;
	}
	
	public WebElement rptValid()
	{
		return reportValid;
	}
	
	public WebElement stkRptValid()
	{
		return stkReportValid;
	}
	
	public WebElement rptGeneration()
	{
		return rptGenStatus;
	}
	
	public void opportunityClk()
	{
		ClickObj(opportunityTab,"Opportunity");
		ClickObj(closePrmt,"Close");
	}
	
	
	public void opportunityDrpdown()
	{
		ClickObj(opportunityTab,"Opportunity");
		ClickObj(closePrmt,"Close");
		
	}
	
	public void newopprtunity()
	{
		ClickObj(newOppr,"New");
		EnterText(opporName,"Salesforce");
		EnterText(accntName,"Resmi Kris");
		String clDate=dateFunction();
		EnterText(closeDate,clDate);
		selectFunction(stage,"Perception Analysis");
		ClickObj(probability,"Probability");
		clearTxtBox(probability);
		EnterText(probability,"75");
		selectFunction(leadSource,"Phone Inquiry");
		EnterText(primaryCampaign,"GC Product Webinar - Jan 7, 2002");
		ClickObj(saveOBtn,"Save");	
	}
	
	public void opportunityPiplinReport()
	{
		ClickObj(pipelineLink,"Pipeline");
		implicitwait();
	}
	
	public void stuckOpportunity()
	{
		ClickObj(stkOpportunity,"Stuck Opportunity");
	}
	
	public void quarterlySummary()
	{
		selectFunction(interval,"Current and Next FQ");
		selectFunction(inclde,"All Opportunities");
		ClickObj(runReportBtn,"Run Report");	
	}
	
	public void quarterlySumry()
	{
		ClickObj(opporLink,"Opportunity");
		selectFunction(interval,"Current FY");
		selectFunction(inclde,"Open Opportunities");
		ClickObj(runReportBtn,"Run Report");
	}
	

}
