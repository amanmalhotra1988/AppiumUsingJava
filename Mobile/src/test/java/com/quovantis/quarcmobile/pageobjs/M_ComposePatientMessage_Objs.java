package com.quovantis.quarcmobile.pageobjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class M_ComposePatientMessage_Objs {
	
	public M_ComposePatientMessage_Objs(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@content-desc = 'PatientComposeButton']")
	public WebElement patientCompose;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(Messages)") 
	public WebElement reply;
	
	@FindBy(xpath="//*[@content-desc = 'ComposeButton']")
	public WebElement directCompose;
	
	@FindBy(xpath="//*[@text = 'Messages']")
	public WebElement messagesIcon;
	
	@FindBy(xpath="//*[@text = 'Directory']")
	public WebElement directoryIcon;
	
	@FindBy(xpath="//*[@text = 'Patients']")
	public WebElement patientsIcon;
	
	@FindBy(xpath="//*[@text = 'Preferences']")
	public WebElement preferencesIcon;
	
	@FindBy(xpath="//*[@content-desc = 'MessageSubjectButton']")
	public WebElement subject;
	
	@FindBy(xpath="//*[@content-desc = 'MessageTextBox']")
	public WebElement messageTextbox;
	
	@FindBy(xpath="//*[@content-desc = 'EditMessage']")
	public WebElement editMessage;
	
	@FindBy(xpath="//*[@content-desc = 'Navigate up']")
	public WebElement navigateUp;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc = 'Navigate up']")
	public WebElement navigateBack;
	
	@FindBy(xpath="//*[@content-desc = 'AddPatientForMessage']")
	public WebElement addPatient;
	
	@FindBy(xpath="//*[@content-desc = 'EditEntryButton']")
	public WebElement editEntry;
	
	@FindBy(xpath="//*[@content-desc = 'Florence Willison']")
	public WebElement patientName;
	
	@FindBy(xpath="//*[@content-desc = 'Send']")
	public WebElement sendButton;

	@FindBy(xpath="//*[@content-desc = 'View Conversation Details']")
	public WebElement viewConversation;

	@FindBy(xpath="//android.widget.TextView[@text='SUBJECT']")
	public WebElement verifySubject;

	

}
