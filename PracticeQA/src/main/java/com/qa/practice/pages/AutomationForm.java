package com.qa.practice.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.practice.testBase.testBase;
import com.qa.practice.testUtil.testUtil;

public class AutomationForm extends testBase {

	@FindBy(xpath="//div[@class='vc_message_box-icon']//following::p[2]/span/em")
	WebElement message; 

	@FindBy(xpath="//input[@name='firstname']")
	static WebElement fName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lName; 
	
	@FindBy(xpath="//input[@value='Male']")
	WebElement maleRBtn; 
	
	@FindBy(xpath="//input[@value='Female']")
	WebElement femaleBtn; 
	
	@FindBy(xpath="//input[@value='1']")
	WebElement yoe1; 
	
	@FindBy(xpath="//input[@id='datepicker']")
	WebElement date; 
	
	@FindBy(xpath="//input[@id='profession-1']")
	WebElement pAutEng; 
	
	@FindBy(xpath="//input[@id='tool-2']")
	WebElement tool; 
	
	@FindBy(xpath="//select[@id='continents']")
	WebElement continents;
	
	@FindBy(xpath="//select[contains(@name,'selenium_commands')]")
	WebElement selCmds;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement submitBtn;
	
	public AutomationForm() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePracticeAutomationTitle()
	{
		return driver.getTitle();
	}
	
	public String ReadMessage()
	{	
		System.out.println(message.getAttribute("innerText"));
		return message.getAttribute("innerText");
	}
	
	public void CreateForm(String afName, String alName, String sex, String YOE, String actDate, String prof, String acontinents) throws InterruptedException
	{
		fName.sendKeys(afName);
		Thread.sleep(5000);
		lName.sendKeys(alName);
		Thread.sleep(6000);
		if(sex.equals("Male"))
		{
			maleRBtn.click();
		}
		else if(sex.equals("Female"))
		{
			femaleBtn.click();
		}
		//@FindBy(xpath="//input[@value='1']")
		//WebElement yoeRBtn = driver.findElement(By.xpath("//input[@value='"+YOE+"'])"));
		yoe1.click();
		date.sendKeys(actDate);
		if(prof.equals("AutomationEng"))
			pAutEng.click();
		tool.click();
		
		Thread.sleep(5000);
		testUtil.highLight(continents, driver);
		//continents.click();
		
		Select sel = new Select(continents);
		sel.selectByVisibleText(acontinents);
		
		
		Select sel1 = new Select(selCmds);
		testUtil.highLight(continents, driver);
		sel1.selectByVisibleText("Browser Commands");
		testUtil.highLight(continents, driver);
		sel1.selectByVisibleText("Wait Commands");
		testUtil.highLight(continents, driver);
		submitBtn.click();
		
	}

}
