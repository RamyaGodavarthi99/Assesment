package com.qa.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBase 
{
	public static  WebDriver driver;
	public static void initialization()  
	{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");	
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver(); 	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ObjectRepository.URL);
	}
		
	public static void close_browser()
	{
		//WebDriver driver = new ChromeDriver();
		driver.quit();
	}


	
	
	
		
}
