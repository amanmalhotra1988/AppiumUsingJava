package com.quovantis.quarcmobile.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.quovantis.quarcmobile.pagemodules.M_Messages_Modules;
import com.quovantis.quarcmobile.testbase.Base_Final;

public class M_Messages extends Base_Final{
	
	@Test
	public void QuarcMobile_Messages() throws InterruptedException, IOException
	{    
		  M_Messages_Modules mdirectory = new M_Messages_Modules(driver);
		  mdirectory.validateMessages();
		  mdirectory.validateEditMessage();
	}


}
