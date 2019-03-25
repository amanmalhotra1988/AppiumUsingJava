package com.quovantis.quarcmobile.testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.quovantis.quarcmobile.pagemodules.M_Login_Modules;
import com.quovantis.quarcmobile.testbase.Base_Final;
import com.quovantis.quarcmobile.util.ExcelUtility;

public class M_Login extends Base_Final
{
	@Test
	public void QuarcMobile_Login() throws InterruptedException, IOException
	{    
		  M_Login_Modules mHome = new M_Login_Modules(driver);
		  driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		  driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		  mHome.loginWithExistingUser(ExcelUtility.getKeyValue("Home", "QuarcMobile_Login", "Username"), ExcelUtility.getKeyValue("Home", "QuarcMobile_Login", "Password"));
	}

}