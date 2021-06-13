package com.crm.comcast.organizationtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class D2createneworgCopybillingaddrenabledornot {
public static void main(String[] args) throws Throwable {
		
		/* crate Object for Utility*/
		 PropertyFileUtility pLib = new PropertyFileUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 WebDriverUtility wLib = new WebDriverUtility();
		 
		 
		/*read common data*/
		 String BROWSER = pLib.readDataFromPropertyFfile("browser");
		 String USERNAME = pLib.readDataFromPropertyFfile("username");
		 String PASSWORD = pLib.readDataFromPropertyFfile("password");
		 String URL = pLib.readDataFromPropertyFfile("url");
		 /*read test script data*/
		 String orgName = eLib.getExcelData("org", 1, 2) + JavaUtility.getRanDomNum();
		 String billingAdd=eLib.getExcelData("org",1,4)  + JavaUtility.getRanDomNum();
		
		  /*step 1 : login to app*/
		 WebDriver driver = null;
		   if(BROWSER.equalsIgnoreCase("firefox")) {
		       driver = new FirefoxDriver();
	     }else if(BROWSER.equalsIgnoreCase("chrome")) {
	   	   driver = new ChromeDriver();
	     }else if(BROWSER.equalsIgnoreCase("ie")) {
	   	   driver = new InternetExplorerDriver();
	     }
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
	       
		 
		/*step 2 : navigate to Orgnization Page*/ 
		   driver.findElement(By.linkText("Organizations")).click();
		  
		   
			/*step 3 : navigate to create Orgnization Page*/ 
			   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
			     
		/*step 4 :To check Copybilling address is enabled or not */
		    driver.findElement(By.name("accountname")).sendKeys(orgName);
		    driver.findElement(By.xpath("//b[text()='Copy Billing address']/preceding-sibling::input")).click();
		    
			  Thread.sleep(10000);
		 
		   /*step 5: logout*/
				  WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				  
				  wLib.mouseOver(driver, adminWb);
				  driver.findElement(By.linkText("Sign Out")).click();
				  driver.close();
				  
				  

		}
}







