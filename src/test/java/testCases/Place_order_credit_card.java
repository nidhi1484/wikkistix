package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import utilities.ExcelUtility;

public class Place_order_credit_card extends BaseClass{
	
			
	@Test (priority=1)
	
	public void addToCart() {
		driver.get("https://staging4.wikkistix.com");
		driver.findElement(By.xpath("//li[@id=\"menu-item-10572\"]//span[@class=\"menu-text\" and text()=\"Shop \"]")).click(); //click on shop menu
		driver.findElement(By.id("menu-item-57531")).click(); 													//click on 'Educational' menu item
		driver.findElement(By.xpath("//a[@href=\"?add-to-cart=52808\"]")).click();
		
		WebElement cartIcon = driver.findElement(By.cssSelector("span[aria-label=\"View Cart\"]"));
						
		action = new Actions(driver);
		action.moveToElement(cartIcon).build().perform();
		
		driver.findElement(By.cssSelector("div.fusion-menu-cart-link>a[href=\"https://staging4.wikkistix.com/cart/\"]")).click();
		
		String title = driver.getTitle();
		
		if (title.equals("Cart | Wikki Stix"))
		{
			System.out.println("cart page opened");				// 1st message
		}
		
		else {
			System.out.println("Cart page title did not match");	// 1st message
		}
			
	}
		
	@Test (priority=2)
	
	public void updateCart() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='button' and @value='+']")).click();
		driver.findElement(By.xpath("//input[@value='Update Cart']")).click();
		
		String success_message = driver.findElement(By.xpath("//*[@class='wc-block-components-notice-banner__content']")).getText();
		
		System.out.println("Success message is displayed: "+ success_message); // 2nd message
		
		WebElement checkoutButton = driver.findElement(By.cssSelector("input#process-to-checkout"));
		
		//wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(("arguments[0].click()"), checkoutButton);
				
		String title = driver.getTitle();
		
		if (title.equals("Checkout | Wikki Stix"))
		{
			System.out.println("checkout page opened");
		}
		
		else {
			System.out.println("Checkout page title did not match");
		}
			
	}
		
	@Test (priority = 3)
	
	public void fillAddressOnCheckoutPage() throws IOException, InterruptedException {
		
				
		String filePath = (".\\testData\\address_data.xlsx");
		
		ExcelUtility ExcelUtility = new ExcelUtility(filePath);
		
		
			String fName = ExcelUtility.getCellData("Sheet1", 1, 1);
			String lName = ExcelUtility.getCellData("Sheet1", 1, 2);
			String street = ExcelUtility.getCellData("Sheet1", 1, 3);
			String city = ExcelUtility.getCellData("Sheet1", 1, 4);
			String state = ExcelUtility.getCellData("Sheet1", 1, 5);
			String zip = ExcelUtility.getCellData("Sheet1", 1, 6);
			String phone = ExcelUtility.getCellData("Sheet1", 1, 7);
			String email = ExcelUtility.getCellData("Sheet1", 1, 8);
			
			System.out.println(fName+" |"+lName+" |"+street+" |"+city+" |"+state+" |"+zip+" |"+phone+" |"+email);
			
			//Boolean loader = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
			
			//WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billing_first_name")));
			//Thread.sleep(5000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
			WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_first_name")));
			firstName.sendKeys(fName);
			driver.findElement(By.id("billing_last_name")).sendKeys(lName);
			
			WebElement country_drpdn = driver.findElement(By.id("billing_country"));
			Select country = new Select(country_drpdn);
			country.selectByValue("US");
			
			driver.findElement(By.id("billing_address_1")).sendKeys(street);
			driver.findElement(By.id("billing_city")).sendKeys(city);
			
			WebElement state_drpdn = driver.findElement(By.id("billing_state"));
			Select st = new Select(state_drpdn);
			st.selectByVisibleText(state);
			
			driver.findElement(By.id("billing_postcode")).sendKeys(zip);
			driver.findElement(By.id("billing_phone")).sendKeys(phone);
			driver.findElement(By.id("billing_email")).sendKeys(email);
			
			List ship_method = driver.findElements(By.xpath("//ul[@id='shipping_method']//li//label"));
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#shipping_method")));
			
			for (Object shipping: ship_method) {
				
				String shipping_options=((WebElement) shipping).getText();
				
				System.out.println(shipping_options);
			}
			
									
		}
		
	@Test (priority = 4)
	
	public void place_order() {
		
		if(driver.findElement(By.id("payment_method_authorize_net_cim_credit_card")).isSelected()) {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
			
				
			if (driver.findElement(By.xpath("//div[contains(@id,\"uw\")]")).isDisplayed()) {
				
				System.out.println(driver.findElement(By.xpath("//div[contains(@id,\"uw\")]")).getText());
				
				
			}
			else {
				System.out.println("Recaptcha error not displayed");
			}
		} 
	}

	
	@AfterClass()
		
		public void close_browser() {
			
			driver.close();
			
		
	}
		
	
}	
	


