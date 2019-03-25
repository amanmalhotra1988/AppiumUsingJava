package com.quovantis.quarcmobile.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base{
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException, InterruptedException {
		//Appium Code
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Quarc_Mobile");
		//cap.setCapability(MobileCapabilityType.APP,"C:\\tomcat902\\webapps\\quarc\\medarchon.quarc.messaging.android-Signed.apk");
		cap.setCapability(CapabilityType.VERSION, "7.1.1");
		cap.setCapability("appPackage", "medarchon.quarc.messaging.android");
		cap.setCapability("appActivity","md559757f7a6ca97240271b03e71b901e35.SplashActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
		
	}
}