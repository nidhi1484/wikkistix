package testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class order_credit_card_login extends BaseClass{
		
	@Test
	
	public void addToCart() throws InterruptedException {
		
				
		driver.findElement(By.cssSelector("#menu-item-10572")).click();		
		driver.findElement(By.cssSelector("#menu-item-57531")).click();
		
		driver.findElement(By.xpath("//a[@href=\"?add-to-cart=52808\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]//a[@href=\"https://staging4.wikkistix.com/checkout/\"]")).click();
		
	}
		
	@Test
	
	public void checkout_page() throws IOException {
		
		
		
		
	}

}
