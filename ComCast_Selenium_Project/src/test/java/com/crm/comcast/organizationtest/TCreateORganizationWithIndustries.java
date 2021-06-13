
package com.crm.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;

public class TCreateORganizationWithIndustries extends BaseClass{
	
    @Test(groups = "regressionTest")
    public void createOrhWithIndustried() throws Throwable {		
		/*read test script data*/

		 String orgName = eLib.getExcelData("org", 4, 2) + JavaUtility.getRanDomNum();
		 String industry = eLib.getExcelData("org", 4, 3); 
		 
		
		/*step 2 : navigate to Orgnization Page*/ 
		   driver.findElement(By.linkText("Organizations")).click();
		  
		/*step 3 : navigate to create Orgnization Page*/ 
		   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		   
		/*step 4 : create new Orgnization*/
		   driver.findElement(By.name("accountname")).sendKeys(orgName);
		   WebElement iwb = driver.findElement(By.name("industry"));
           wLib.select(iwb, industry);
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		/*step 5 : Verify orgname & industries*/  
		   String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  if(actSuccessFullMsg.contains(orgName)) {
				  System.out.println(orgName + "==>Orgnization created successfully==>PASS");
			  }else {
				  System.out.println(orgName + "==>Orgnization not created ==>Fail");

			  }
			  
			  String actIndustryMsg = driver.findElement(By.id("dtlview_Industry")).getText();
			  if(actIndustryMsg.contains(industry)) {
				  System.out.println(orgName + "==>Orgnization created with industry successfully==>PASS");
			  }else {
				  System.out.println(orgName + "==>Orgnization not created with industry==>Fail");

			  }

			  

	}

}
