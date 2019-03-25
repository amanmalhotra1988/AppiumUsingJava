package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class M_Directory_Objs {
	
	public M_Directory_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@text = 'Directory']")
	public WebElement directoryIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='  Directory']")
	public WebElement directoryHeader;
	
	@FindBy(xpath="//android.widget.TextView[@text='Search']")
	public WebElement searchDirectory;
	
	@FindBy(className="android.widget.EditText")
	public WebElement searchName;
	
	@FindBy(xpath="//*[@content-desc = 'IsFavorite']")
	public WebElement countDirectory;
	
	@FindBy(xpath="//android.widget.TextView[@text='Email']")
	public WebElement emailLabel;
	
	@FindBy(xpath="//android.widget.TextView[@text='Phone']")
	public WebElement phoneLabel;
	
	@FindBy(xpath="//android.widget.TextView[@text='Office']")
	public WebElement officeLabel;
	
	@FindBy(xpath="//android.widget.TextView[@text='Tags']")
	public WebElement tagsLabel;
	
	@FindBy(xpath="//android.widget.TextView[@text='Teams']")
	public WebElement teamsLabel;
	
	@FindBy(xpath="//android.widget.TextView[@text='Roles']")
	public WebElement rolesLabel;
		
	@FindBy(xpath="//*[@content-desc = 'Navigate up']")
	public WebElement navigateUp;
	
	
	
	
}
