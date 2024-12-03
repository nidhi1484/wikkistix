package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gravity_form {
	
	@Test
	public void addToCart() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://staging4.wikkistix.com");
		
		driver.findElement(By.xpath("//a[@href=\"https://staging4.wikkistix.com/sign-up/\"]")).click();
		driver.findElement(By.name("input_1")).sendKeys("nidhi");
		driver.findElement(By.name("input_2")).sendKeys("nidhi@focusindia.com");
		driver.findElement(By.id("recaptcha-anchor")).click();
		driver.findElement(By.id("gform_submit_button_2")).click();

}
}
