package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.quovantis.quarcmobile.pageobjs.M_Directory_Objs;
import com.quovantis.quarcmobile.pageobjs.M_Messages_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class M_Messages_Modules extends Base_Final{
M_Messages_Objs messagesObj = null;
	
	public M_Messages_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		messagesObj = new M_Messages_Objs(driver);
	}

	public void validateMessages() throws InterruptedException, IOException, MalformedURLException
	{  
		test.log(Status.INFO, "Navigating to 'Messages' Section of QUARC");
		messagesObj.messagesIcon.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Verifying the Header under 'Messages' Screen");
		messagesObj.messagesHeader.getText().trim();
	
		Assert.assertEquals(messagesObj.messagesHeader.getText().trim(), "Messages", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "Header is OK i.e "   + "<br>" + "<b>" +messagesObj.messagesHeader.getText() + "</b>");
	}
	
	public void validateEditMessage() throws InterruptedException, IOException, MalformedURLException
	{  
		test.log(Status.INFO, "Clicking on 'EDIT' icon under Messages Screen");
		messagesObj.messagesEdit.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Verifying the Objects after clicking on EDIT icon");
		messagesObj.searchplaceholder.getText().trim();
	
		Assert.assertEquals(messagesObj.searchplaceholder.getText().trim(), "Search", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "Placeholder text 'Search' is visible : "   + "<br>" + "<b>" +messagesObj.searchplaceholder.getText() + "</b>");
	    
	    Assert.assertEquals(messagesObj.filter.getText().trim(), "Filter", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "'FILTER' button is visible"   + "<br>" + "<b>" +messagesObj.filter.getText() + "</b>");
    
	    Assert.assertEquals(messagesObj.delete.getText().trim(), "Delete", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "'DELETE' button is visible"   + "<br>" + "<b>" +messagesObj.delete.getText() + "</b>");
    	
	    test.log(Status.INFO, "Clicking on a message to delete it from QUARC");
	    
	    messagesObj.selectRadio.click();
	    test.log(Status.PASS, "Clicked on a message to Delete");	 
	   
	    messagesObj.delete.click();
	    test.log(Status.PASS, "Clicked on DELETE Button");
	    
	    messagesObj.done.click();
	    test.log(Status.PASS, "Clicked on DONE Button");
	    Thread.sleep(2000);
	}

}
