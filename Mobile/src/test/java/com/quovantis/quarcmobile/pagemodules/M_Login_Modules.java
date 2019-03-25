package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.quovantis.quarcmobile.pageobjs.M_Login_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class M_Login_Modules extends Base_Final{
	M_Login_Objs logObj = null;
		
	public M_Login_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		logObj = new M_Login_Objs(driver);
	}

	public void loginWithExistingUser(String Username, String Password) throws InterruptedException, IOException, MalformedURLException
	{  
		test.log(Status.INFO, "Quarc Mobile Application Launched Successfully");
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		test.log(Status.INFO, "Navigated to QUARC - ORGANIZATION CODE Authentication Screen");
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
        	
		MobileElement element = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Please enter your 6-digit organization code.']"));
	    String organizationCodeMessage = element.getText();
	    
	    if(organizationCodeMessage.equals("Please enter your 6-digit organization code."))
	    {
	    	test.log(Status.PASS, "6-Digit Organization Code Message is displayed as :" + "<b>" + organizationCodeMessage + "</b>");
	    }
	    else 
	    {
	    	test.log(Status.FAIL, "6-Digit Organization Code Message is incorrect" + "<b>" + organizationCodeMessage + "</b>");
	    }
		logObj.organizationCode.clear();
		logObj.organizationCode.sendKeys("QAENV1");
		test.log(Status.PASS, "Successfully entered the 6-digit Organization Code as :" + "<b>" + "QAENV1" + "</b>");
		test.log(Status.INFO, "Clicking on 'CONNECT' BUTTON");
		logObj.Submit.click();
    	Thread.sleep(3000);
    	Assert.assertTrue(logObj.Username.isDisplayed());	

		test.log(Status.INFO, "Navigated to Login Page of Quarc Mobile Application");
    	logObj.Username.sendKeys(Username);
		test.log(Status.PASS, "Entered Username Successfully :  " + "<b>" + Username + "</b>");
		Thread.sleep(1000);

		logObj.Password.clear();
		logObj.Password.sendKeys(Password);
		test.log(Status.PASS, "Entered Password Successfully :  " + "<b>" + Password + "</b>");
		logObj.Submit.click();
		test.log(Status.PASS, "Clicked on LOG IN Button");
		WebDriverWait wait3 = new WebDriverWait(driver, 40);
		  wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc = 'Pin1']")));
		  Assert.assertTrue(logObj.createPINLabel.isDisplayed());
		  test.log(Status.PASS, "Successfully Logged in to the QUARC Application");
	}
		
}
