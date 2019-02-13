package com.qa.practice.testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.qa.practice.testBase.testBase;

public class testUtil extends testBase{
	


	public testUtil() throws IOException {
	
	}

	public static long IMPLICIT_WAIT = 2000;
	public static long PAGELOAD_TIME = 3000; 
	
	public static void highLight(WebElement element, WebDriver driver)
    {
        for (int i = 0; i <5; i++) 
        {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 4px solid red;");
                Thread.sleep(500);
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                Thread.sleep(500);
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }

        }

    }

	
		public static void takeScreenshotAtEndOfTest() throws IOException
		{
			File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir= System.getProperty("user.dir");
			FileUtils.copyFile(scr,new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
		}
		
	

}
