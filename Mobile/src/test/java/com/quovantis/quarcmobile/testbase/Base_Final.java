package com.quovantis.quarcmobile.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.naming.ConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.internal.IResultListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.quovantis.quarcmobile.config.Constants;
import com.quovantis.quarcmobile.util.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base_Final implements IResultListener {
	public static AndroidDriver<AndroidElement> driver =null;
    public static Properties config = null;
    public static FileInputStream input = null;
    public static boolean isInitialized=false;
    public static boolean isBrowserOpened= false;
    public static String env_url ="";
    public static ITestResult result;
    public static String filePath= Constants.REPORT_FILE;
    public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.REPORT_FILE + "Mobile_AutomationReport.html");
    public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	public static void init() throws ConfigurationException 
    {   
    	//System.out.print("This method has been called to Read Config File before any execution gets started");
    	if (!isInitialized) 
		{
			try 
			{					
				ReadConfig.loadProperty(); 			
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
    }

	
	@BeforeSuite
	public void report_method() throws UnknownHostException {
		extent.attachReporter(htmlReporter);
		java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
		extent.setSystemInfo("Machine Name", localMachine.getHostName());
		//extent.setSystemInfo("QA Environment", "<a href =" + "https://qa.medarchon.com/" + ">"+ "https://qa.medarchon.com/" + "</a>");
		
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		htmlReporter.config().setReportName("QUARC Mobile Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
			
	@BeforeTest
	public void beforeCallingAnyTestCase() throws ConfigurationException, IOException, InterruptedException
	{   Base_Final bs= new Base_Final();
		//init();
	    driver = Base_Final.setCapabilities();
		System.out.println("Mobile Capabilities launched Successfully on Emulator");
  	}
	
	@AfterTest
	public void af()
	{
		//driver.quit();	
	}
	public static AndroidDriver<AndroidElement> setCapabilities() throws MalformedURLException, InterruptedException {
			//Appium Code
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Quarc_Android");
			//cap.setCapability(MobileCapabilityType.APP,"C:\\tomcat902\\webapps\\quarc\\medarchon.quarc.messaging.android-Signed.apk");
			cap.setCapability(CapabilityType.VERSION, "7.1.1");
			cap.setCapability("appPackage", "medarchon.quarc.messaging.android");
			cap.setCapability("appActivity","md559757f7a6ca97240271b03e71b901e35.SplashActivity");
			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return driver;
			}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getMethodName());
			}
	public void onTestSuccess(ITestResult result) {
            /*try {
			
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			String imageName = result.getMethod().getMethodName();
		    String property = filePath+imageName+".png";
			
			//String property = System.getProperty("user.dir")+"//Screenshots//"+imageName+".png";
			File dest=new File(property);
			FileUtils.copyFile(SrcFile, dest);
	
			test.log(Status.PASS, result.getThrowable());
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(property).build());
			test.addScreenCaptureFromPath(property);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	public void onTestFailure(ITestResult result) {
        /*try {
			
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			String filePath= Constants.REPORT_FILE;
			String imageName = result.getMethod().getMethodName();
		    String property = filePath+imageName+".png";
			
			//String property = System.getProperty("user.dir")+"//Screenshots//"+imageName+".png";
			File dest=new File(property);
			FileUtils.copyFile(SrcFile, dest);
	
			test.log(Status.FAIL, result.getThrowable());
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(property).build());
			test.addScreenCaptureFromPath(property);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();

	}
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
		
	
}
