package com.quovantis.quarcmobile.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.quovantis.quarcmobile.pagemodules.M_CreatePIN_Modules;
import com.quovantis.quarcmobile.testbase.Base_Final;


public class M_CreatePIN extends Base_Final{
	
	@Test
	public void QuarcMobile_CreatePIN() throws InterruptedException, IOException
	{     M_CreatePIN_Modules mcreatePIN = new M_CreatePIN_Modules(driver);
	      mcreatePIN.createPIN();
	}

}
