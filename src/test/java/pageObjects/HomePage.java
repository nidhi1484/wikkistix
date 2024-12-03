package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		
		super(driver);
		
	}

@FindBy (xpath = "//*[@id=\"menu-item-59394\"]//span[text()=\"My Account\"]") 
WebElement Myaccount;	
	

public void clickMyaccount() {
	
	Myaccount.click();
}


}
