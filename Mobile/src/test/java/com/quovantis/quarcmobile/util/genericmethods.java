package com.quovantis.quarcmobile.util;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.quovantis.quarcmobile.config.Constants;
import com.quovantis.quarcmobile.testbase.Base_Final;

public class genericmethods extends Base_Final {
	
	//This method is used to generate Random Strings
	public static int generateRandomNumber() 
	{
		Random rand = new Random(); 
		int value = rand.nextInt(500);
		return value; 
	}
	
	public static void captureScreenshots() throws IOException
	{
           try {
        	         	   
             TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			String filePath= Constants.REPORT_FILE;
			//String imageName = result.getMethod().getMethodName();
		    String property = filePath + "MobileScreenshot_" + formatDateToString()+ ".png";
			
			//String property = System.getProperty("user.dir")+"//Screenshots//"+imageName+".png";
			File dest=new File(property);
			FileUtils.copyFile(SrcFile, dest);
	
			//test.log(Status.PASS, result.getThrowable());
			test.pass("Screenshot herewith", MediaEntityBuilder.createScreenCaptureFromPath(property).build());
			test.addScreenCaptureFromPath(property);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String formatDateToString() 
	{ 
	DateFormat df = new SimpleDateFormat("dd/MM/yy kk:mm:ss aa"); 
	Date dateObj = new Date(); 
	String dateToString = df.format(dateObj); 
	String formatDate = dateToString.replace('/', '_'); 
	formatDate = formatDate.replace(' ', '_'); 
	formatDate = formatDate.replace(':', '_'); 

	//System.out.println(formatDate); 
	return formatDate; 

	}
	
	public static String connectDatabase() throws ClassNotFoundException, SQLException, UnknownHostException 
	{
		int count = 0;
		Random random = new Random();
		ArrayList<String> ar = new ArrayList<String>();
		Connection m_Connection;
		if(Inet4Address.getLocalHost().getHostAddress().equals("172.31.21.89"))
	    {
	    	 m_Connection = DriverManager.getConnection(
	    	 "jdbc:sqlserver://localhost;DatabaseName=MEDarchon-QA", "quarc-sql", "19C3=19Aj16LEVI"); 
	    }
	    else
	    {
	    	 m_Connection = DriverManager.getConnection(
	    	        "jdbc:sqlserver://localhost;DatabaseName=MEDarchon", "sa", "sql@123");
	    }
		   
	    Statement m_Statement = m_Connection.createStatement();
	    String query = "/****** Script for SelectTopNRows command from SSMS  ******/\r\n" + 
	    		"SELECT  [Id]\r\n" + 
	    		"      ,[StaffId]\r\n" + 
	    		"      ,[Name]\r\n" + 
	    		"      ,[FirstName]\r\n" + 
	    		"      ,[LastName]\r\n" + 
	    		"      ,[Title]\r\n" + 
	    		"      ,[Email]\r\n" + 
	    		"      ,[Phone]\r\n" + 
	    		"      ,[OfficePhone]\r\n" + 
	    		"      ,[Pager]\r\n" + 
	    		"      ,[LastModified]\r\n" + 
	    		"      ,[Created]\r\n" + 
	    		"      ,[UserLastSeenTimestamp]\r\n" + 
	    		"      ,[DisabledFromAd]\r\n" + 
	    		"      ,[DisabledFromQuarc]\r\n" + 
	    		"      ,[OnlineStatus]\r\n" + 
	    		"      ,[WizardCompletedDate]\r\n" + 
	    		"  FROM [MEDarchon].[readmodels].[UserInfo]";

	    ResultSet m_ResultSet = m_Statement.executeQuery(query);
	    while (m_ResultSet.next())
	    {
	    ar.add(m_ResultSet.getString(3));
	    count++;
	    }
	    int randomIdx = random.nextInt(count);
	    m_Connection.close();
	    return ar.get(randomIdx);
	    }

}
