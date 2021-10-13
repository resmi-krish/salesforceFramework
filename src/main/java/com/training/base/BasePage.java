package com.training.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void implicitwait()
	{
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	
	public void SelectCheckBox(WebElement WebElChkbox, String SelectTextName )
	{
		waitforElement(WebElChkbox);
		WebElChkbox.click();
	}
	
	public void ClickObj(WebElement WebElClick,String ClickName)
	{
		waitforElement(WebElClick);
		WebElClick.click();
	}
	
	public void EnterText(WebElement WebElEntr,String InpText)
	{
		waitforElement(WebElEntr);
		WebElEntr.sendKeys(InpText);
	}
	
	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitforElementToClick(WebElement element_clk) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element_clk));
		
	}
	
	public void waitforFrameToAvailable(String Framewaitid) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Framewaitid));
		
	}
	
	public void waitforUrl(String strUrl) {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.urlToBe(strUrl));
		
	}
	
	public void iframeswitch(String FrameID,String Framenme)
	{
		driver.switchTo().frame(FrameID);
	}
	
	public void iframeswitch(WebElement Framexpath,String Framname)
	{
		driver.switchTo().frame(Framexpath);
	}
	
	public void switchfromframe()
	{
		driver.switchTo().defaultContent();
	}
	
	public void MouseHover(WebElement WebElHover,String HoverText)
	{
	    Actions action=new Actions(driver);
		action.moveToElement(WebElHover).build().perform();
	}
	
	public void pagescrolldown(WebElement WebElscroll)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitforElement(WebElscroll);
		js.executeScript("arguments[0].scrollIntoView();", WebElscroll);
	}
	
	public void selectFunction(WebElement WebElSel,String StrVal)
	{
		Select sel=new Select(WebElSel);
		sel.selectByVisibleText(StrVal);
	}
	
	public void clearTxtBox(WebElement WebElClrTxt)
	{
		waitforElement(WebElClrTxt);
		WebElClrTxt.clear();
	}
	
	public void alertAccept()
	{
		driver.switchTo().alert().accept();
	}
	
	public String getUrl()
	{
		return(driver.getCurrentUrl());
	}
	
	public void windowSwitch()
	{
		System.out.println("No of window handles:"+driver.getWindowHandles().size());
		for(String handle: driver.getWindowHandles())
		{
            driver.switchTo().window(handle);
		}
	}
	
	public String storeParentWindow()
	{
		return(driver.getWindowHandle());
	}
	
	public void switchbackToParent(String strhandle)
	{
		driver.switchTo().window(strhandle);
	}
	
	public void currentWindowClose()
	{
		driver.close();
	}
	
	public String dateFunction()
	{
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String todayDate=formatter.format(today);
		return todayDate;
	}
	
	public String dateadd7Function()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Using today's date
		c.add(Calendar.DATE, 7); // Adding 7 days
		String output = sdf.format(c.getTime());
		return output;
	}
	

}