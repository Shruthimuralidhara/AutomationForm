package com.qa.practice.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.practice.testUtil.WebEventListener;
import com.qa.practice.testUtil.testUtil;

public class testBase {
	
	public static WebDriver driver;
	public static Properties prop; 

public static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
	
	
	//Constructor of class to load Config File
	public testBase() throws IOException
	{
		try {
			System.out.println("Loading base class");
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Shruthi Muralidhara\\Desktop\\Practice\\PracticeQA\\src\\main\\java\\com\\qa\\practice\\config\\config.properties");
			prop.load(ip);
			}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void intializeBrowser() throws IOException
	{
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\DriversDownloaded\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Driver initialized to chrome driver");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGELOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.get(prop.getProperty("url"));
		
	}
}
