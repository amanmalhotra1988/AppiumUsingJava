package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.quovantis.quarcmobile.pageobjs.M_CreatePIN_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class M_CreatePIN_Modules extends Base_Final {
	M_CreatePIN_Objs createPINObj = null;
	
	public M_CreatePIN_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		createPINObj = new M_CreatePIN_Objs(driver);
	}
	
	public void createPIN() throws InterruptedException, IOException, MalformedURLException
	{  
		  test.log(Status.INFO, "Navigating to QUARC - PIN Creation Screen");  
		  
		  test.log(Status.PASS, "Successfully logged in to the QUARC Mobile Application");
		  test.log(Status.INFO, "Entering the 4-Digit PIN");
		  
		  createPINObj.pin2.click();
		  createPINObj.pin2.click();
		  createPINObj.pin2.click();
		  createPINObj.pin2.click();
		  Thread.sleep(2000);
		  test.log(Status.PASS, "Successfully Entered 4-Digit PIN");
		  
		  test.log(Status.INFO, "Entering the 4-Digit PIN again");
		  createPINObj.pin2.click();
		  createPINObj.pin2.click();
		  createPINObj.pin2.click();
		  createPINObj.pin2.click();
		  
		  Thread.sleep(3000);
		  test.log(Status.PASS, "Successfully Entered 4-Digit PIN again");
		  
	}
	
}
