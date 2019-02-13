package com.qa.practice.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.practice.pages.AutomationForm;
import com.qa.practice.testBase.testBase;

public class ApplicationFormTest extends testBase {
	
	AutomationForm aut; 

	public ApplicationFormTest() throws IOException {
		super();
		
	}

	@BeforeMethod()
	public void setUp() throws IOException
	{
		intializeBrowser();
		aut = new AutomationForm();
		String actTitle = aut.validatePracticeAutomationTitle();
		Assert.assertEquals(actTitle, "Demo Form for practicing Selenium Automation");
	}
	
	@Test
	public void validateMsg()
	{
		String actMessage = aut.ReadMessage();
		Assert.assertEquals(actMessage, "Always click on the ads display at the right side, this is how we manage the website’s expenses and bring free content for the beginners.");
	}
	
	
	@Test
	public void CreateUserForm() throws InterruptedException
	{
		aut.CreateForm("Shruthi", "Muralidhara", "Female", "5", "13-02-2019", "AutomationEng", "Europe");
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
