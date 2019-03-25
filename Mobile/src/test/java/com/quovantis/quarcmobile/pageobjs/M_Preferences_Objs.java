package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class M_Preferences_Objs {
	
	public M_Preferences_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text = 'Preferences']")
	public WebElement preferencesIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='    Preferences']")
	public WebElement preferencesHeader;

	@FindBy(xpath="//android.widget.TextView[@text='PUSH NOTIFICATION']")
	public WebElement label1;
	
	@FindBy(xpath="//android.widget.TextView[@text='MESSAGE PREFERENCES']")
	public WebElement label2;
	
	@FindBy(xpath="//android.widget.TextView[@text='SYSTEM']")
	public WebElement label3;
	
	@FindBy(className="android.widget.Switch")
	public WebElement switchbutton;
	
	@FindBy(xpath="//android.widget.TextView[@text='Direct Message Notifications']")
	public WebElement pushNotificationOption;
	
	@FindBy(xpath="//android.widget.TextView[@text='Send My Message To']")
	public WebElement messagePreferencesOption1;
	
	@FindBy(xpath="//android.widget.TextView[@text='Contact Method']")
	public WebElement messagePreferencesOption2;
	
	@FindBy(xpath="//android.widget.TextView[@text='Second Call Order']")
	public WebElement messagePreferencesOption3;
	
	@FindBy(xpath="//android.widget.TextView[@text='Mass Notification Order']")
	public WebElement messagePreferencesOption4;
	
	@FindBy(xpath="//android.widget.TextView[@text='About']")
	public WebElement systemOption;
	
	@FindBy(xpath="//android.widget.Button[@text='Log out']")
	public WebElement logout;
	
	@FindBy(xpath="//android.widget.Button[@text='Logout and Deregister Device']")
	public WebElement logoutanddergister;
	
	@FindBy(xpath="//android.widget.Button[@text='Reset PIN']")
	public WebElement resetpin;
	
	@FindBy(xpath="//android.widget.TextView[@text='  About QUARC']")
	public WebElement aboutQuarc;
	
	@FindBy(xpath="//android.widget.Button[@text='Patents and Legal']")
	public WebElement patentandlegal;
	
	@FindBy(xpath="//android.widget.Button[@text='Terms of Use']")
	public WebElement termsofuse;
	
	@FindBy(className="android.widget.TextView")
	public List<WebElement> version;
	
	@FindBy(xpath="//*[@content-desc = 'Navigate up']")
	public WebElement navigateUp;
	
	
}
