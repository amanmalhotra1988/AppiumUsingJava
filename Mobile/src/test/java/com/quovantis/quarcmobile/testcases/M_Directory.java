package com.quovantis.quarcmobile.testcases;

import java.io.IOException;
import java.sql.SQLException;
import org.testng.annotations.Test;
import com.quovantis.quarcmobile.pagemodules.M_Directory_Modules;
import com.quovantis.quarcmobile.testbase.Base_Final;

public class M_Directory extends Base_Final{
	
	@Test
	public void QuarcMobile_Directory() throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{     
		  M_Directory_Modules mdirectory = new M_Directory_Modules(driver);
		  mdirectory.validateDirectory();
		  mdirectory.gettingContactDetails();
	}
}
