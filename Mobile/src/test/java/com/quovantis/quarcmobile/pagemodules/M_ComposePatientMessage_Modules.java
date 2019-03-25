package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import com.quovantis.quarcmobile.pageobjs.M_ComposePatientMessage_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class M_ComposePatientMessage_Modules extends Base_Final{
	
M_ComposePatientMessage_Objs composeMessage = null;
	
	public M_ComposePatientMessage_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		composeMessage = new M_ComposePatientMessage_Objs(driver);
	}
	
	public void composePMessge() throws InterruptedException, IOException, MalformedURLException
	{  
		  test.log(Status.INFO, "Navigating to QUARC -Default Landing Screen"); 
		  Assert.assertTrue(composeMessage.patientCompose.isDisplayed());
		  Assert.assertTrue(composeMessage.directCompose.isDisplayed());
		  Assert.assertTrue(composeMessage.messagesIcon.isDisplayed());
		  Assert.assertTrue(composeMessage.directoryIcon.isDisplayed());
		  Assert.assertTrue(composeMessage.patientsIcon.isDisplayed());
		  Assert.assertTrue(composeMessage.preferencesIcon.isDisplayed());
		  
		 		  
		  if(composeMessage.messagesIcon.getText().equals("Messages")
		  && composeMessage.directoryIcon.getText().equals("Directory")
		  && composeMessage.patientsIcon.getText().equals("Patients")
		  && composeMessage.preferencesIcon.getText().equals("Preferences"))
		  
		  { 
		  test.log(Status.PASS, "Successfully Validated the following components after logging to QUARC Application:-" 
		          + "<br>" + composeMessage.messagesIcon.getText()
				  + "<br>" + composeMessage.directoryIcon.getText()
		          + "<br>" + composeMessage.patientsIcon.getText()
				  + "<br>" + composeMessage.preferencesIcon.getText());
		  }
		  else
		  {
			  test.log(Status.FAIL, "Looks like 'Messages', or 'Directory', or 'Patients' or 'Preferences' Icons are not visible");
		  }
		  
		  composeMessage.patientCompose.click();
		  test.log(Status.PASS, "Clicked on 'Compose Patient Message' button"); 
		  Thread.sleep(3000);
		  
		 /* MobileElement element = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='To: ']"));
	      String to = element.getText();
	      MobileElement element2 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Subject: ']"));
	      String sub = element2.getText();
	          
	      test.log(Status.INFO, "Validated that 'To' and 'Subject' Field are visible:  " + "<br>" +to  + "<br>" + sub);
	       */  
		  composeMessage.subject.sendKeys("Subject is mandatory field");
		  test.log(Status.PASS, "Successfully Entered the Subject Message "); 
		  
		  /*MobileElement element3 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='This message will be sent to patient or patient's representative. Recipient will be notified by SMS.']"));
	      String visibleMessage = element3.getText();
	      
	      if(element3.getText().equals("This message will be sent to patient or patient's representative. Recipient will be notified by SMS."))
	      {
	    	  test.log(Status.PASS, "Successfully validated the visible text just below the Subject Field as" + "<br>" + visibleMessage);
	      }
	      else 
	      {
	    	  test.log(Status.FAIL, "Visible text just below the Subject Field is not as per expectation");
	      }*/
	           
		  
		  composeMessage.messageTextbox.click();
		  test.log(Status.PASS, "Successfully clicked on 'Type Message' text area"); 
		  Thread.sleep(2000);
		  composeMessage.editMessage.sendKeys("Testing through automation1234");
		  test.log(Status.PASS, "Successfully Entered the Text Message"); 
		  composeMessage.navigateUp.click();
		  test.log(Status.PASS, "Successfully clicked on Back Button after entering the Message"); 
		  Thread.sleep(2000);
		  composeMessage.addPatient.click();
		  test.log(Status.PASS, "Successfully clicked on Patient drop down "); 
		  Thread.sleep(2000);
		  composeMessage.editEntry.click();
		  composeMessage.editEntry.sendKeys("Florence Willis");
		  test.log(Status.PASS, "Successfully entered the Patient Name");
		  Thread.sleep(10000);
		  composeMessage.patientName.click();
		  Thread.sleep(3000);
		  test.log(Status.PASS, "Successfully selected the Patient Name from the drodown");
		  composeMessage.sendButton.click();
		  test.log(Status.PASS, "Successfully clicked on 'Send' button");
		  Thread.sleep(2000);
		  composeMessage.navigateBack.click();
		  		  
	}

}
