package com.crm.comcast.ObjectRepository;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class PurchaseInfoPage {
		
	WebDriver driver;
		
		//Step 2
	 public PurchaseInfoPage(WebDriver driver) {
		 this.driver = driver;
		  PageFactory.initElements(driver, this);
	 }

	 @FindBy(xpath = "//span[@class='lvtHeaderText']")
	 private WebElement successfulMsg;
	 
	 public WebElement getsuccessfulMsg()
	 {
		 return successfulMsg;
	 }
	 
	}
