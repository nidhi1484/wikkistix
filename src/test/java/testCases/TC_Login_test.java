package testCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC_Login_test extends BaseClass{
	
	
				
	@Test
			
	public void login(){
		
		logger.info("********** Starting TC_Login_Test *************");
		
				
		HomePage hp = new HomePage(driver);			// using page object class
		hp.clickMyaccount();
		System.out.println("Clicked my account");
		
	}
		
	@Test
	
	public void login_credentials() throws InterruptedException {
		
			
		String email = pr.getProperty("email");
		String pass = pr.getProperty("password");
		
		LoginPage lp = new LoginPage(driver);		// using page object class
		
		lp.setUserName(email);
		lp.setPassword(pass);
		lp.clickSubmit();
		
		boolean MyAccount = lp.login_success();
		
		Assert.assertEquals(MyAccount, true, "Login Failed");
								
			
		logger.info("********** End TC_Login_Test *************");
	}
	
	}
	

