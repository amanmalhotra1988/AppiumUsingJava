package com.quovantis.quarcmobile.pagemodules;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import com.quovantis.quarcmobile.pageobjs.M_Patients_Objs;
import com.quovantis.quarcmobile.testbase.Base_Final;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class M_Patients_Modules extends Base_Final{
     M_Patients_Objs patientsObj = null;
	
	public M_Patients_Modules(AndroidDriver<AndroidElement> odriver)
	{
		this.driver=odriver;
		patientsObj = new M_Patients_Objs(driver);
	}

	public void validatePatients() throws InterruptedException, IOException, MalformedURLException
	{  
		test.log(Status.INFO, "Navigating to 'Patients' Section of QUARC");
		patientsObj.patientsIcon.click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Verifying the Header under 'Patients' Screen");
		patientsObj.patientsHeader.getText().trim();
	
		Assert.assertEquals(patientsObj.patientsHeader.getText().trim(), "Patient Census", "Actual Header and Expected Header are not matched");
	    test.log(Status.PASS, "Header is OK i.e "   + "<br>" + "<b>" +patientsObj.patientsHeader.getText() + "</b>");
    
		
	}

}
