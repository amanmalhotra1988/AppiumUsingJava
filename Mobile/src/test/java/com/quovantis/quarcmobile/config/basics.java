package com.quovantis.quarcmobile.config;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends Base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		 
		  System.out.println("test is running");
	      WebDriverWait wait = new WebDriverWait(driver, 40);
		  driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		  driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		  WebDriverWait wait1 = new WebDriverWait(driver, 40);
		  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
		  driver.findElementByClassName("android.widget.EditText").clear();
		  driver.findElementByClassName("android.widget.EditText").sendKeys("QAENV1");
		  driver.findElementByClassName("android.widget.Button").click();
		 
		  Thread.sleep(3000);
		  driver.findElementByXPath("//android.widget.EditText[@text = 'Username']").sendKeys("sshoul");
		  Thread.sleep(1000);

		  driver.findElement(By.xpath("//*[@content-desc = 'PasswordTextBox']")).clear();
		  driver.findElementByXPath("//*[@content-desc = 'PasswordTextBox']").sendKeys("Qa4MED@");
		  driver.findElementByClassName("android.widget.Button").click();

		  WebDriverWait wait3 = new WebDriverWait(driver, 40);
		  wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc = 'Pin1']")));
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin2']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin3']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin4']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin5']")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin2']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin3']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin4']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'Pin5']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@content-desc = 'PatientComposeButton']")).click();
		  
		  Thread.sleep(3000);
		  
		  MobileElement element = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='To: ']"));
	      String get = element.getText();

		  System.out.println("Got the label  " + get);
		  driver.findElement(By.xpath("//*[@content-desc = 'MessageSubjectButton']")).sendKeys("How are you doing today");
		  
		  driver.findElement(By.xpath("//*[@content-desc = 'MessageTextBox']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@content-desc = 'EditMessage']")).sendKeys("Testing through automation");
		  driver.findElement(By.xpath("//*[@content-desc = 'Navigate up']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@content-desc = 'AddPatientForMessage']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@content-desc = 'EditEntryButton']")).click();
		  driver.findElement(By.xpath("//*[@content-desc = 'EditEntryButton']")).sendKeys("florence Willis");
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//*[@content-desc = 'Florence Willison']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@content-desc = 'Send']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@content-desc = 'View Conversation Details']")).click();
		  Thread.sleep(2000);
		  MobileElement element2 = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='SUBJECT']"));
	      String getSubject = element2.getText();
	      System.out.println("Got the Subject Line" + getSubject);
		  
	}
}
