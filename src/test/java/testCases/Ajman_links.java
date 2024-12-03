package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajman_links {
	
	
WebDriver driver;
	
@Test	
public void openBrowser() {
		
		WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver();
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15)); 
	    
		driver.manage().window().maximize();
		
		driver.get("https://www.sendflowerstoajman.com/choose-by-flowers/carnations/");
		
		List <WebElement> links = driver.findElements(By.xpath("//*[@id = \"productlist\"]//div//a")); 
		
		System.out.println(links.size());
		
		for (WebElement linkElement: links) {
			
			String hrefvalue = linkElement.getAttribute("href");
			
			
			if (hrefvalue==null || hrefvalue.isEmpty()) {
				
				System.out.println("Href attribute value is empty or null");
				continue;
			}
		
		System.out.println(hrefvalue);
		

}

}

}
