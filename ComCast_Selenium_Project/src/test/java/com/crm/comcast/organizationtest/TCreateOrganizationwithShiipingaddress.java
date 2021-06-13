package com.crm.comcast.organizationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInfoPage;
import com.crm.comcast.ObjectRepository.OrganizationsPage;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;

public class TCreateOrganizationwithShiipingaddress extends BaseClass {
	 @Test(groups = "regressionTest")
	public void tcreateorgwithshippingaddress() throws Throwable {
		
	

	
	/*read test script data*/
	 String orgName = eLib.getExcelData("org", 1, 2) + JavaUtility.getRanDomNum();
	 String shippingAdd=eLib.getExcelData("org",1,3)  + JavaUtility.getRanDomNum();
	 
	
       
	 /*step 2 : navigate to Orgnization Page*/ 
	  // driver.findElement(By.linkText("Organizations")).click();
	 HomePage hp=new HomePage(driver);
	  hp.navigateOrg();
	
	/*step 3 : navigate to create Orgnization Page*/ 
	  // driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	   
	/*step 4 : create new Orgnization*/
	   //driver.findElement(By.name("accountname")).sendKeys(orgName);
	   //driver.findElement(By.name("ship_street")).sendKeys(shippingAdd);
	   //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  OrganizationsPage org=new    OrganizationsPage(driver);
	   org.createOrg();
	/*step 5 : create new Verify org created with shippingaddress*/  
	  // String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   
		  //if(actSuccessFullMsg.contains(orgName)) {
			//  System.out.println(orgName + "==>Orgnization created successfully==>PASS");
		  //}else {
			//  System.out.println(orgName + "==>Orgnization not created ==>Fail");

		 // }
	   

	   OrganizationInfoPage oif=new OrganizationInfoPage(driver);
	   String actSuccessFullMsg=oif.getSuccessfullMsg().getText();
	   
	Assert.assertTrue(actSuccessFullMsg.contains(orgName));
		 // String actshippingMsg = driver.findElement(By.id("mouseArea_Shipping Address")).getText();
		  //if(actshippingMsg.contains(shippingAdd)) {
			//  System.out.println(orgName + "==>Orgnization created with shippingaddress successfully==>PASS");
		  //}else {
			//  System.out.println(orgName + "==>Orgnization not created with shippingaddress==>Fail");

		 // }}
		  //}
	  
		 OrganizationInfoPage oif1=new OrganizationInfoPage(driver);
		   String actshippingMsg=oif1.getWithShippingadd().getText();
		   
		Assert.assertTrue(actshippingMsg.contains(shippingAdd));
	 }
}
			  

			  