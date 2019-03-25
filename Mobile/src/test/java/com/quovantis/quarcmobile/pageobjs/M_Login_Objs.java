package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class M_Login_Objs {
	
	public M_Login_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.EditText[@text = 'Username']")
	public WebElement Username;
	
	@FindBy(xpath="//*[@content-desc = 'PasswordTextBox']")
	public WebElement Password;
	
	@FindBy(className="android.widget.Button")
	public WebElement Submit;
	
	@FindBy(className="android.widget.EditText")
	public WebElement organizationCode;
	
	@FindBy(xpath="//android.widget.TextView[@text='Please enter your 6-digit organization code.']")
	public WebElement organizationCodeMessage;
	
	@FindBy(xpath="//android.widget.TextView[@text = 'Create PIN']")
	public WebElement createPINLabel;

}
