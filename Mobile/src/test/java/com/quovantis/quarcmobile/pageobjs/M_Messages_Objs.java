package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class M_Messages_Objs {
	
	public M_Messages_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@text = 'Messages']")
	public WebElement messagesIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='  Messages']")
	public WebElement messagesHeader;
	
	@FindBy(xpath="//android.widget.TextView[@text='Edit']")
	public WebElement messagesEdit;
	
	@FindBy(xpath="//android.widget.TextView[@text='Search']")
	public WebElement searchplaceholder;
	
	@FindBy(xpath="//android.widget.Button[@text='Delete']")
	public WebElement delete;
	
	@FindBy(xpath="//android.widget.Button[@text='Filter']")
	public WebElement filter;
	
	@FindBy(xpath="//android.widget.TextView[@text='Done']")
	public WebElement done;
	
	@FindBy(xpath="//android.widget.RelativeLayout[3]")
	public WebElement selectRadio;
}
