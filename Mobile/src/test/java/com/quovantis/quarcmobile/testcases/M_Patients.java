package com.quovantis.quarcmobile.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.quovantis.quarcmobile.pagemodules.M_Patients_Modules;
import com.quovantis.quarcmobile.pagemodules.M_Preferences_Modules;
import com.quovantis.quarcmobile.testbase.Base_Final;

public class M_Patients extends Base_Final{
	
	@Test
	public void QuarcMobile_Patients() throws InterruptedException, IOException
	{    
		  M_Patients_Modules mpreferences = new M_Patients_Modules(driver);
		  mpreferences.validatePatients();
	}

}
