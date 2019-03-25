package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.quovantis.quarcmobile.pageobjs.M_Preferences_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class M_Preferences_Modules extends Base_Final{
	M_Preferences_Objs preferencesObj = null;
	boolean versionflag=false;
	public M_Preferences_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		preferencesObj = new M_Preferences_Objs(driver);
	}

	
	public void validatePreferences() throws InterruptedException, IOException, MalformedURLException
	{  
		test.log(Status.INFO, "Navigating to 'Preferences' Section of QUARC");
		preferencesObj.preferencesIcon.click();
		Thread.sleep(2000);
		
		test.log(Status.INFO, "Verifying the Header under 'Preferences' Screen");
	    preferencesObj.preferencesHeader.getText().trim();
	    
	    Assert.assertEquals(preferencesObj.preferencesHeader.getText().trim(), "Preferences", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "Header is OK i.e "   + "<br>" + "<b>" +preferencesObj.preferencesHeader.getText() + "</b>");
        test.log(Status.INFO, "Verifying the Labels under 'Preferences' Screen");
	    
	    Assert.assertEquals(preferencesObj.label1.getText().trim(), "PUSH NOTIFICATION", "Actual Label and Expected Label are not matched");
	    Assert.assertEquals(preferencesObj.label2.getText().trim(), "MESSAGE PREFERENCES", "Actual Label and Expected Label are not matched");
	    Assert.assertEquals(preferencesObj.label3.getText().trim(), "SYSTEM", "Actual Label and Expected Label are not matched");
	    
	    
	    test.log(Status.PASS, "Following Headers are displayed on Preferences Screen"  + "<b>" + "<br>"
	    		+ preferencesObj.label1.getText().trim() + "<br>"
	    		+ preferencesObj.label2.getText().trim() + "<br>"
	    		+ preferencesObj.label3.getText().trim() + "<b>");
	    
	    test.log(Status.INFO, "Verifying the option under 'PUSH NOTIFICATION' Section");
	    Assert.assertEquals(preferencesObj.pushNotificationOption.getText().trim(), "Direct Message Notifications", "Actual and Expected option under 'PUSH NOTIFICATION' section are not matched");
	    test.log(Status.PASS, "All options under 'PUSH NOTIFICATION' Section are OK"  + "<br>" + "<b>" +preferencesObj.pushNotificationOption.getText() + "</b>");
	    
	   Point point= preferencesObj.switchbutton.getLocation();
	    TouchAction t = new TouchAction(driver);
	    t.tap(PointOption.point(point.x+20, point.y+30)).perform();
        test.log(Status.PASS, "Toggle Button ON for 'Direct Message Notifications' ");
        t.tap(PointOption.point(point.x, point.y)).perform();	
		test.log(Status.PASS, "Toggle Button OFF for 'Direct Message Notifications' ");
	    test.log(Status.INFO, "Verifying the option under 'Message Preferences' Section");
	    Assert.assertEquals(preferencesObj.messagePreferencesOption1.getText().trim(), "Send My Message To", "Actual and Expected option under 'MESSAGE PREFERENCES' section are not matched");
	    Assert.assertEquals(preferencesObj.messagePreferencesOption2.getText().trim(), "Contact Method", "Actual and Expected option under 'MESSAGE PREFERENCES' section are not matched");
	    Assert.assertEquals(preferencesObj.messagePreferencesOption3.getText().trim(), "Second Call Order", "Actual and Expected option under 'MESSAGE PREFERENCES' section are not matched");
	    Assert.assertEquals(preferencesObj.messagePreferencesOption4.getText().trim(), "Mass Notification Order", "Actual and Expected option under 'MESSAGE PREFERENCES' section are not matched");
	    test.log(Status.PASS, "All options under 'MESSAGE PREFERENCES' Section are OK"  + "<br>" + "<b>"
	             + preferencesObj.messagePreferencesOption1.getText() + "<br>"
	             + preferencesObj.messagePreferencesOption2.getText() + "<br>"
	             + preferencesObj.messagePreferencesOption3.getText() + "<br>"
	             + preferencesObj.messagePreferencesOption4.getText() + "</b>");
	    
	    test.log(Status.INFO, "Verifying the option under 'System' Section");
	    Assert.assertEquals(preferencesObj.systemOption.getText().trim(), "About", "Actual and Expected option under 'SYSTEM' section are not matched");
	    test.log(Status.PASS, "All options under 'SYSTEM' Section are OK"  + "<br>" + "<b>" +preferencesObj.systemOption.getText() + "</b>");
        
	    
        //Identify Element using Content Description
	    MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
	    				"new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView("
	    				+ "new UiSelector().description(\"DeregisterButton\"))"));
        
	    test.log(Status.INFO, "Scrolling on 'PREFERENCES' Screen to view the buttons");
	    
	    Assert.assertEquals(preferencesObj.logout.getText().trim(), "Log out", "Actual and Expected option under 'PREFERENCES' section are not matched");
	    Assert.assertEquals(preferencesObj.logoutanddergister.getText().trim(), "Logout and Deregister Device", "Actual and Expected option under 'PREFERENCES' section are not matched");
	    Assert.assertEquals(preferencesObj.resetpin.getText().trim(), "Reset PIN", "Actual and Expected option under 'PREFERENCES' section are not matched");
	    
	    test.log(Status.PASS, "Following buttons are visible on 'Preferences' Page after Scrolling"  + "<br>" + "<b>"
	             + preferencesObj.logout.getText().toUpperCase() + "<br>"
	             + preferencesObj.logoutanddergister.getText().toUpperCase() + "<br>"
	             + preferencesObj.resetpin.getText().toUpperCase() + "</b>");
	      
	    test.log(Status.INFO, "Clicking on 'About' option to view the Version of QUARC");
	    preferencesObj.systemOption.click();	
	    test.log(Status.PASS, "Navigated to 'About' Screen");
	    
	    test.log(Status.INFO, "Verifying the Header under 'About' Screen");
	    Thread.sleep(2000);
	    Assert.assertEquals(preferencesObj.aboutQuarc.getText().trim(), "About QUARC", "Actual and Expected header under 'About' screen are not matched");
	    test.log(Status.PASS, "Following Headers validated"  + "<b>" + "<br>"
	    		+ preferencesObj.aboutQuarc.getText().trim());
	    
	    test.log(Status.INFO, "Verifying the Version of QUARC Application");
	    List<WebElement> elements = preferencesObj.version;
	    java.util.Iterator<WebElement> program = elements.iterator();
	    while (program.hasNext()) {
	        String values = program.next().getText();

	        if(values.contains("Version"))
	        {
	        	 test.log(Status.PASS, "Version of QUARC Application is visible i.e " + "<b>" +values + "</b>");
	        	 versionflag=true;
	        	 break;
	        }
	    }
	    if(!versionflag)
	    {
	    	test.log(Status.FAIL, "Version of QUARC Application is not visible");
	    }
	        
	    test.log(Status.INFO, "Verifying the links 'PATENT AND LEGAL' and 'TERMS OF USE'");
        Assert.assertEquals(preferencesObj.patentandlegal.getText().trim().toUpperCase(), "PATENTS AND LEGAL", "Actual and Expected buttons under 'About' screen are not matched");
        Assert.assertEquals(preferencesObj.termsofuse.getText().trim().toUpperCase(), "TERMS OF USE", "Actual and Expected buttons under 'About' screen are not matched");
        
	    test.log(Status.PASS, "Following buttons validated"  + "<b>" + "<br>"
	    		+ preferencesObj.patentandlegal.getText().trim().toUpperCase() + "<br>"  
	            + preferencesObj.termsofuse.getText().trim().toUpperCase() + "</b>");
	    
	    
	    preferencesObj.navigateUp.click();
	    test.log(Status.PASS, "Navigated to 'Preferences' Screen again");
	    Thread.sleep(2000);
	    
	}
}
