package com.quovantis.quarcmobile.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.quovantis.quarcmobile.pagemodules.M_Preferences_Modules;
import com.quovantis.quarcmobile.testbase.Base_Final;
import com.quovantis.quarcmobile.util.ExcelUtility;

public class M_Preferences extends Base_Final{
	
	@Test
	public void QuarcMobile_Preferences() throws InterruptedException, IOException
	{    
		  M_Preferences_Modules mpreferences = new M_Preferences_Modules(driver);
		  mpreferences.validatePreferences();
	}

}
