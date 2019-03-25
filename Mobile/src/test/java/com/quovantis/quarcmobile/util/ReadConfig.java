package com.quovantis.quarcmobile.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.quovantis.quarcmobile.config.Constants;
import com.quovantis.quarcmobile.testbase.Base_Final;

public class ReadConfig extends Base_Final

{
	public static void loadProperty() throws IOException 
	{
		config = new Properties();
		input =new FileInputStream(Constants.PROP_FILE);
		
		System.out.println("Constants File for Mobile " + Constants.PROP_FILE );
		config.load(input);
	
	}
}



