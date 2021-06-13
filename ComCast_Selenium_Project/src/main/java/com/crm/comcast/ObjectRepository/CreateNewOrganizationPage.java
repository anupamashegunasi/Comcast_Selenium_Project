package com.crm.comcast.ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.crm.comcast.genericutility.WebDriverUtility;

	public class CreateNewOrganizationPage extends WebDriverUtility{
		
		WebDriver driver;

		public CreateNewOrganizationPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name = "accountname")
		private WebElement orgNameEdt;
		
		

		@FindBy(name = "industry")
		private WebElement industryEdt;
		@FindBy(name = "ship_street")
		private WebElement shipAddEdt1;
		
		@FindBy(name = "billingAdd")
		private WebElement billAddEdt1;
	
		@FindBy(xpath = "//b[text()='Copy Shipping address']/preceding-sibling::input")
		private WebElement shippAddSelect1;
		
		@FindBy(xpath = "//b[text()='Copy Billing address']/preceding-sibling::input")
		private WebElement billAddSelect1;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveButtonLnk;
		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getIndustryEdt() {
			return industryEdt;
		}

		public WebElement getShipAddEdt1() {
			return shipAddEdt1;
		}

		public WebElement getBillAddEdt1() {
			return billAddEdt1;
		}

		public WebElement getShippAddSelect1() {
			return shippAddSelect1;
		}

		public WebElement getBillAddSelect1() {
			return billAddSelect1;
		}

		public WebElement getSaveButtonLnk() {
			return saveButtonLnk;
		}

		
		public void createOrganization(String OrgName)
		{
			orgNameEdt.sendKeys(OrgName);
			waitForElemnetToBeVisible(driver, saveButtonLnk);
			saveButtonLnk.click();
		}
		
		public void createOrgWithIndustry(String OrgName, String industry)
		{
			orgNameEdt.sendKeys(OrgName);
			select(industryEdt, industry);
			waitForElemnetToBeVisible(driver, saveButtonLnk);
			saveButtonLnk.click();
		}
		public void createOrgWithoutShippingAddress(String OrgName)
		{
			orgNameEdt.sendKeys(OrgName);
		
			waitForElemnetToBeVisible(driver, saveButtonLnk);
			saveButtonLnk.click();
		}
	
		public void createOrgWithShippingAddress(String OrgName, String shippingAdd)
		{
			orgNameEdt.sendKeys(OrgName);
			shipAddEdt1.sendKeys(shippingAdd);
			waitForElemnetToBeVisible(driver, saveButtonLnk);
			saveButtonLnk.click();
		}
		
	public void createOrgWithBillingAddress(String OrgName, String billingAdd)
	{
		orgNameEdt.sendKeys(OrgName);
		billAddEdt1.sendKeys(billingAdd);
		waitForElemnetToBeVisible(driver, saveButtonLnk);
		saveButtonLnk.click();
	}
	public void createOrgcopyShiipingAddEnabled(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
	
		waitForElemnetToBeVisible(driver, shippAddSelect1);
		shippAddSelect1.click();
	}
	public void createOrgcopyBillingAddEnabled(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
	
		waitForElemnetToBeVisible(driver, billAddSelect1);
		billAddSelect1.click();
	}
	
	}
