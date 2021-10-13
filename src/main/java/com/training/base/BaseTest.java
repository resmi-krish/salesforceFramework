package com.training.base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();;
		driver = new ChromeDriver();
		return driver;
	}
	
	
	public static void takescreenshot(WebDriver driver) throws IOException {
		
		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
		  File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		  
		  	Date currentDate = new Date();
		  	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		  	String fileSeperator = System.getProperty("file.separator");
		    String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "Screenshots";
		    String reportFileName = "ScreenShot"+timestamp+".png";
		    String filePath =  reportFilepath +fileSeperator+ reportFileName;
		    File DestFile = new File(filePath);
		    FileUtils.copyFile(srcFile, DestFile);
		
	}
   
	public String getTitle()
	{
		return(driver.getTitle());
	}
	
	public void assertFun(String actualVal, String expectedVal)
	{
    	Assert.assertEquals(actualVal, expectedVal);	
	}
	
	public void arrayassert(String actualtext,String expectedtext)
	{
		
		assertEquals(actualtext, expectedtext);
	}
	
	public String GetTextFun(WebElement WebElTxt,String GetTextName )
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(WebElTxt));
		String Text=WebElTxt.getText();
		return Text;
		
	}
}