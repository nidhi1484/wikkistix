package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	public LoginPage (WebDriver driver){
		
		super(driver);
	}

	
	// locators
	
	// @FindBy(how=How.XPATH, using="//input[@id='username']") WebElement username;		//alternative approach
	
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//button[@name='login']") WebElement login_btn;
	@FindBy(xpath="//h2[contains(text(),\"Dashboard\")]") WebElement Dashboard;
	@FindBy(xpath="//a[text()=\"Log out\"]") WebElement Logout;
	
	// action methods
	
	public void setUserName(String user) {
		
		username.sendKeys(user);
	}
	
	public void setPassword(String pw) {
		
		password.sendKeys(pw);
	}
	
	public void clickSubmit () {
		
		login_btn.click();
	}
	
	public boolean login_success() {
		
					
		return Dashboard.isDisplayed();
		
		}
	
	public void clickLogout() {
		
		Logout.click();
	}
	}
	
	
	// RandomStringUtils
	

