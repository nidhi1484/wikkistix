package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_withoutPageFactory {
	
	WebDriver driver;
	
	public LoginPage_withoutPageFactory (WebDriver driver){
		
		this.driver=driver;
		
	}

	
	// locators
	
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By login_btn = By.xpath("//button[@name='login']");
	
	// action methods
	
	public void setUserName(String user) {
		
		driver.findElement(username).sendKeys(user);
	}
	
	public void setPassword(String pw) {
		
		driver.findElement(password).sendKeys(pw);
	}
	
	public void clickSubmit () {
		
		driver.findElement(login_btn).click();
	}
	
	
	
	
}
