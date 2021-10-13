package com.training.pages;

import java.beans.Visibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.base.BasePage;


public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "name")
	WebElement firstName;
	
	@FindBy(id = "userNav-menuItems")
	WebElement userNavMenu;
	
	@FindBy(xpath = "//a[@title='My Profile']")
	WebElement profileopt;
	
	@FindBy(xpath = "//span[normalize-space()='File']")
	WebElement FileLink;
	
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement EditProfile;
	
	@FindBy(id = "aboutTab")
	WebElement AboutTab;
	
	@FindBy(id = "lastName")
	WebElement Lname;
	
	@FindBy(xpath = "//input[@value='Save All']")
	WebElement Save;
	
	@FindBy(id = "userNavLabel")
	WebElement ProfileName;
	
	@FindBy(xpath = "//span[normalize-space()='Post']")
	WebElement PostLinkTab;
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    WebElement frame_xpath;
	
	@FindBy(xpath = "//body")
	WebElement TextEnter;
	
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	WebElement Share;
	
	@FindBy(xpath = "//span[@class='feeditemtext cxfeeditemtext']")
	WebElement share_validate;
	
	@FindBy(xpath = "//a[normalize-space()='Upload a file from your computer']")
	WebElement fileFromComputer;
	
	@FindBy(id = "chatterFile")
	WebElement FileUpload;
	
	@FindBy(id = "publishersharebutton")
	WebElement FileShare;
	
	@FindBy(xpath = "//td[@class='moreFileActions-td']//span[@class='contentActionLabel'][normalize-space()='Download png']")
    WebElement fileShareValidate;
	
	@FindBy(id = "displayBadge")
	WebElement photoLink;
	
	@FindBy(id = "uploadLink")
	WebElement AddPhto;
	
	@FindBy(className = "fileInput")
	WebElement PhotoUpload;
	
	@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
	WebElement SavePhoto;
	
	@FindBy(xpath = "//div[@class='imgCrop_clickArea']")
	WebElement CropArea;
	
	@FindBy(id = "j_id0:j_id7:save")
	WebElement CropImgSave;
	
	@FindBy(xpath = "//a[normalize-space()='My Settings']")
	WebElement mySettings;
	
	@FindBy(xpath = "//span[@id='PersonalInfo_font']")
	WebElement PersonalLnk;
	
	@FindBy(xpath = "//span[@id='LoginHistory_font']")
	WebElement LoginHis;
	
	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	WebElement downloadlogin;
	
	@FindBy(xpath = "//tr/th[@scope='row']")
	WebElement latestLogin;
	
	@FindBy(id = "DisplayAndLayout_font")
	WebElement displayLink;
	
	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
	WebElement customizeTab;
	
	@FindBy(id = "p4")
	WebElement SalesForceChatter;
	
	@FindBy(id = "duel_select_0")
	WebElement report;
	
	@FindBy(xpath = "//img[@title='Add']")
	WebElement addReport;
	
	@FindBy(name = "save")
	WebElement reportSave;
	
	@FindBy(id = "report_Tab")
	WebElement reportSalesforce;
	
	@FindBy(linkText = "Reports")
	WebElement reportChatter;
	
	@FindBy(xpath = "//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('EmailSetup');\"]")
	WebElement emailLink;
	
	@FindBy(xpath = "//span[@id='EmailSettings_font']")
	WebElement emailSettings;
	
	@FindBy(id = "sender_name")
	WebElement emailName;
	
	@FindBy(id = "sender_email")
	WebElement emailID;
	
	@FindBy(id = "auto_bcc1")
	WebElement radioBtn;
	
	@FindBy(name = "save")
	WebElement emailSave;
	
	@FindBy(className = "messageText")
	WebElement emailSaveMsg;
	
	@FindBy(id = "CalendarAndReminders_font")
	WebElement calenderRemind;
	
	@FindBy(xpath = "//span[@id='Reminders_font']")
	WebElement activityReminder;
	
	@FindBy(id = "testbtn")
	WebElement reminderBtn;
	
	@FindBy(id = "dismiss_all")
	WebElement dismissBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Developer Console']")
	WebElement devConsole;
	
	
	public String expected_Txt="My Profile My Settings Developer Console Switch to Lightning Experience Logout";
	public String frame_id="contactInfoContentId";
	public String frame_photo="uploadPhotoContentId";
	public String Lname_new="Sukumaran";
	public String expected_Name="Resmi Sukumaran";
	public String Enter_text="Selenium Automation";
	public String upload_Location="C:\\Users\\resmi\\Pictures\\Salesforce testcases-output\\Testcase1.png";
	public String Photo_Location="C:\\Users\\resmi\\Pictures\\Saved Pictures\\testphoto.jpg";
	public String expectedfileText="Download png";
	public String expected_report="Reports";
	public String email_name="testname";
	public String email_enter="abcdtest@gmail.com";
	public String email_message="Your settings have been successfully saved.";
	public String expecteddevTitle="Developer Console";
	
	public WebElement userNav()
	{
		return userNavMenu;
	}
	
	public WebElement ProfName()
	{
		return ProfileName;
	}
	
	public WebElement ShareValid()
	{
		return share_validate;
	}
	
	public WebElement fileShareValid()
	{
		return fileShareValidate;
	}
	
	public WebElement latestLoginValidate()
	{
		return latestLogin;
	}
	
	public WebElement reportSalesForce()
	{
		return reportSalesforce;
	}
	
	public WebElement reportChatterValid()
	{
		return reportChatter;
	}
	
	public WebElement emailMessage() 
	{
		return emailSaveMsg;
	}
	
	public WebElement dismissAll() 
	{
		return dismissBtn;
	}
	
	public void myProfileclick()
	{
		ClickObj(profileopt,"My profile");
	}
	
	public void editProfile()
	{
		waitforElement(FileLink);
		ClickObj(EditProfile,"Edit profile");	
	}
	
	public void aboutTab()
	{
		iframeswitch(frame_id,"Switch to edit iframe");
		ClickObj(AboutTab,"About Tab");
		clearTxtBox(Lname);
		EnterText(Lname,Lname_new);
		ClickObj(Save,"Save All");
		implicitwait();
	}
	
	public void postLinkclick()
	{
		ClickObj(PostLinkTab,"Post Link");
		iframeswitch(frame_xpath,"Switching to text area");
		EnterText(TextEnter,Enter_text);
		switchfromframe();
		ClickObj(Share,"Share button");
		waitforElementToClick(Share);
	}
	
	public void fileLinkclick()
	{
		ClickObj(FileLink,"File link");
		ClickObj(fileFromComputer,"Upload from computer");
		EnterText(FileUpload,upload_Location);
		ClickObj(FileShare,"Share button");
		waitforElementToClick(FileShare);
	}
	
	public void addphotocrop()
	{
		waitforElement(photoLink);
		MouseHover(photoLink,"Mouse Over");
		ClickObj(AddPhto,"Photo link");
		iframeswitch(frame_photo,"iframe switch");
		EnterText(PhotoUpload,Photo_Location);
		ClickObj(SavePhoto,"Save");
		waitforElement(CropArea);
		Actions action=new Actions(driver);
		action.clickAndHold(CropArea).moveByOffset(50, 0).release().build().perform();
		ClickObj(CropImgSave,"CropImage Save");
	}

	public void mySettingsclick()
	{
		ClickObj(mySettings,"My Settings");
	}
	
	public void personalLink()
	{
		ClickObj(PersonalLnk,"Personal");
		ClickObj(LoginHis,"Login History");
		ClickObj(downloadlogin,"Download Loginhistory");
	}
	
	public void displayLayoutLink()
	{
		pagescrolldown(displayLink);
		ClickObj(displayLink,"Display&Layout");
		ClickObj(customizeTab,"customize Tab");
		selectFunction(SalesForceChatter,"Salesforce Chatter");
		selectFunction(report,"Reports");
		ClickObj(addReport,"Add Report");
		ClickObj(reportSave,"Save Report");
	}
	
	public void emailLink()
	{
		pagescrolldown(emailLink);
		ClickObj(emailLink,"Email link");
		ClickObj(emailSettings,"Email Settings");
		clearTxtBox(emailName);
		EnterText(emailName,email_name);
		clearTxtBox(emailID);
		EnterText(emailID,email_enter);
		ClickObj(radioBtn,"Bcc Radio Button");
		pagescrolldown(emailSave);
		ClickObj(emailSave,"Save email Settings");	
		alertAccept();
	}
	
	public void calendarReminder() throws InterruptedException
	{
		pagescrolldown(calenderRemind);
		ClickObj(calenderRemind,"Calendars and Reminders");
		ClickObj(activityReminder,"Activity Reminder");
		ClickObj(reminderBtn,"Test reminder Button");
		Thread.sleep(5000);
		windowSwitch();	
	}
	
	public void developerConsole()
	{
		ClickObj(devConsole,"Developer Console");
		windowSwitch();
	}
}


		

	