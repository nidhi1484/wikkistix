package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class Login_test_DDT extends BaseClass {
	
	@Test(dataProvider="loginData", dataProviderClass = DataProviders.class)// getting data provider from different class
	public void login_verify_DDT() {
		
		HomePage hp = new HomePage(driver);			// using page object class
		hp.clickMyaccount();
		
		LoginPage lp = new LoginPage(driver);		// using page object class
		
		lp.setUserName(pr.getProperty("email"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickSubmit();
		
		System.out.println(driver.getTitle());
		
		if (driver.findElement(By.xpath("//h2[contains(text(),\"Dashboard\")]")).isDisplayed()) {
			
			Assert.assertTrue(true);
			System.out.println("login sucessful");
			
			driver.findElement(By.linkText(null));
						
			}
		
		else {
		
			Assert.fail();
			System.out.println("login not successful");
			

	}

	}
	
	
}
	
	