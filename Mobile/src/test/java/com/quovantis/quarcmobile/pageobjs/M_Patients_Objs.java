package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class M_Patients_Objs {
	public M_Patients_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@text = 'Patients']")
	public WebElement patientsIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='  Patient Census']")
	public WebElement patientsHeader;

}
