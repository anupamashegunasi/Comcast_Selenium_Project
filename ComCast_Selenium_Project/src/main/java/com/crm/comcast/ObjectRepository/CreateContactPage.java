package com.crm.comcast.ObjectRepository;

	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;

	public class CreateContactPage {
		
		WebDriver driver;

		public CreateContactPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		
	}