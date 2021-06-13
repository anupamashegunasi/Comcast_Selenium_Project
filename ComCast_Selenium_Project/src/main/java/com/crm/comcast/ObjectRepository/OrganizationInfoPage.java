package com.crm.comcast.ObjectRepository;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.crm.comcast.genericutility.WebDriverUtility;

	public class OrganizationInfoPage extends WebDriverUtility {
		
		WebDriver driver;

		public OrganizationInfoPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement successfullMsg;
		
		

		@FindBy(name="mouseArea_Billing Address")
		private WebElement withBillingadd;
		
		@FindBy(id="mouseArea_Shipping Address")
		private WebElement withShippingadd;
		
		@FindBy(id="mouseArea_Shipping Address")
		private WebElement withoutShippingadd;
		
		public WebElement getSuccessfullMsg() {
			return successfullMsg;
		}

		public WebElement getWithBillingadd() {
			return withBillingadd;
		}

		public WebElement getWithShippingadd() {
			return withShippingadd;
		}

		public WebElement getWithoutShippingadd() {
			return withoutShippingadd;
		}
	}
	

		
