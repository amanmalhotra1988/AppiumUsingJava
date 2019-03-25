package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.quovantis.quarcmobile.util.genericmethods;
import com.quovantis.quarcmobile.pageobjs.M_Directory_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class M_Directory_Modules extends Base_Final{
	
M_Directory_Objs directoryObj = null;
boolean isUserFound=false;
	
	public M_Directory_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		directoryObj = new M_Directory_Objs(driver);
	}

	public void validateDirectory() throws InterruptedException, IOException, MalformedURLException
	{  
		test.log(Status.INFO, "Navigating to 'Directory' Section of QUARC");
		directoryObj.directoryIcon.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Verifying the Header under 'Directory' Screen");
		directoryObj.directoryHeader.getText().trim();
	
		Assert.assertEquals(directoryObj.directoryHeader.getText().trim(), "Directory", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "Header is OK i.e "   + "<br>" + "<b>" +directoryObj.directoryHeader.getText() + "</b>");
    
	}
	
	public void gettingContactDetails() throws ClassNotFoundException, UnknownHostException, SQLException, InterruptedException
    {  
   	    //Search for a User in Directory Screen 
   	    String randomUser = genericmethods.connectDatabase();
   	    test.log(Status.PASS,"Succesfully Connected to the QUARC Database");
   	    Assert.assertTrue(directoryObj.searchDirectory.isDisplayed());
   	    test.log(Status.PASS,"Search textbox is visible for Searching 'Doctor Name' in Directory");
   	    test.log(Status.INFO,"Entering the Doctor Name in Directory List");
   	    directoryObj.searchDirectory.click();
		directoryObj.searchName.sendKeys(randomUser);	
			
			Thread.sleep(2000);
		    int TotalCount = driver.findElements(By.xpath("//*[@content-desc = 'IsFavorite']")).size();
		    if(TotalCount==0)
			{ 
				test.log(Status.INFO,"Directory List is not getting populated");
			}
			else
			{
				for(int i=1;i <=TotalCount;i++)
				{
				String getValue =  driver.findElement(By.xpath("//android.widget.TextView[@text = '"+randomUser+"']")).getText();
		
				    if(getValue.equals(randomUser))
				    {
				    	driver.findElement(By.xpath("//android.widget.TextView[@text = '"+randomUser+"']")).click();
				    	driver.findElement(By.xpath("//android.widget.TextView[@text = '"+randomUser+"']")).click();
				    	isUserFound = true;
				    	Thread.sleep(2000);
				    	Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = '"+randomUser+"']")).getText().equals(randomUser), "Looks like we are not navigated to Directory Contact Details");
				    	test.log(Status.PASS,"We are able to see the Contact details for user : " + "<b>" + getValue  + "</b>");
				    	break;
				    }
				}
				if(!isUserFound)	
				{
					test.log(Status.INFO,"User found in DB but not visible on UI" );
				}
			}	
		    
			Assert.assertTrue(directoryObj.emailLabel.isDisplayed());
			Assert.assertTrue(directoryObj.phoneLabel.isDisplayed());
			Assert.assertTrue(directoryObj.officeLabel.isDisplayed());
			test.log(Status.PASS,"'Email', 'Phone' and 'Office' Label under Contact Details are displayed.");
		    Assert.assertEquals(directoryObj.tagsLabel.getText().trim(), "Tags", "Actual Header and Expected Header are not matched");
		    Assert.assertEquals(directoryObj.teamsLabel.getText().trim(), "Teams", "Actual Header and Expected Header are not matched");
		    Assert.assertEquals(directoryObj.rolesLabel.getText().trim(), "Roles", "Actual Header and Expected Header are not matched");
		    test.log(Status.PASS,"'Tags', 'Teams' and 'Roles' Label under Contact Details are displayed.");
		    
		    directoryObj.navigateUp.click();
			Thread.sleep(3000);
	}
	
}
