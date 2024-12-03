package basePackage;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties pr;
	public WebDriverWait wait;
	public Actions action;
	public FileReader file;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"browser"})

	public void browser_setup(String br) throws IOException {
		
		
		file = new FileReader(".//src//test//resources//properties_file");           // location of properties file
		
		pr = new Properties();                                                       // Loading properties file
		pr.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("invalid browser name"); return;
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    wait= new WebDriverWait(driver,Duration.ofSeconds(15));
	    
		driver.get(pr.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	
	public void tearDown() throws IOException{
		
		file.close();
		driver.quit();
		
	}
}