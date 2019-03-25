package com.quovantis.quarcmobile.util;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.quovantis.quarcmobile.testbase.Base_Final;

public class SendEmail extends Base_Final
{
	@Test(enabled=true)
	public void emailReport() throws InterruptedException, IOException
	{
		String fileName = "";
        final String username = "quarcautomation@gmail.com";
        final String password = "Germany@123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");		
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username, password);
            }
          });

     try {
        	/*//String currentDir = System.getProperty("user.dir");
            //public File getLastFileName= Null;
            System.out.println(System.getProperty("user.dir"));*/
            
            if(Inet4Address.getLocalHost().getHostAddress().equals("172.31.21.89"))
            {
            	fileName = "C:\\tomcat902\\webapps\\quarc\\" + "Mobile_AutomationReport.html";
            }
            else
            {
            	fileName = "C:\\tomcat902\\webapps\\quarc\\" + "Mobile_AutomationReport.html";
            	//fileName = System.getProperty("user.dir") + "/testData/AutomationReport.html";
            }
            File getLastFileName = new File(fileName);
  
            String reportFilePath = getLastFileName.toString();
          	driver.get(reportFilePath);
        	
            MimeMessage message = new MimeMessage(session);
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("<font color='#0b5394'>"
            + "Hello Team," + "<br />" + "<br />"
           	+ "</B>" + "</U>" + "Here is the QUARC_MOBILE Smoke Tests Execution Summary for today." + "</U>" + "</B>" + "<br/>" + "<br/>"
           	+ "<a href = 'http://34.211.30.119:8081/quarc/Mobile_AutomationReport.html'>Click here for detail reporting</a>" + "<br/>" + "<br/>"
			+ "If you have any concerns or suggestions, please reach out to:<U>aman.malhotra@quovantis.com</U>" + "<br />" + "<br />"
			+ "******<u>This is an auto generated email. Please do not reply to this email, as this email ID is not monitored.</u>******"
			+ "<br />" + "<br />" + "<br />" + "Thanks & Regards," + "<br />" + "QUARC QA Team" + "</font>" , "text/html; charset=utf-8");
            
            MimeBodyPart attachmentPart = new MimeBodyPart();
            
            multipart.addBodyPart(messageBodyPart);
           //multipart.addBodyPart(attachmentPart);
            
            String filename = reportFilePath;

            DataSource source = new FileDataSource(filename);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(filename);
            
            message.setFrom(new InternetAddress("quarcautomation@gmail.com"));
           
            String emailIds = "aman.malhotra@quovantis.com";
            /*message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailIds));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("ajay.mor@quovantis.com"));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("ankit.raheja@quovantis.com"));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("sam.shoultz@medarchon.com"));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("ann.shafer@medarchon.com"));
           */
            message.setSubject("QUARC_MOBILE - Smoke Automation Report || DAILY RUN");
            message.setContent(multipart);
            Transport.send(message);
           
            System.out.println("Mail Sent Successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}