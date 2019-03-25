package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class M_CreatePIN_Objs {
	
	public M_CreatePIN_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text = 'Create PIN']")
	public WebElement createPINLabel;
	
	@FindBy(xpath="//*[@content-desc = 'Pin2']")
	public WebElement pin2;
	
	@FindBy(xpath="//*[@content-desc = 'Pin3']")
	public WebElement pin3;
	
	@FindBy(xpath="//*[@content-desc = 'Pin4']")
	public WebElement pin4;
	
	@FindBy(xpath="//*[@content-desc = 'Pin5']")
	public WebElement pin5;
	
}
