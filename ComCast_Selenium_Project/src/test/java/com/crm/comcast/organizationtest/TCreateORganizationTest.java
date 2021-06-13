
package com.crm.comcast.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.CreateNewOrganizationPage;
import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.OrganizationInfoPage;
import com.crm.comcast.ObjectRepository.OrganizationsPage;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;

public class TCreateORganizationTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		
		/*read test script data*/
		int ranDomNum =  JavaUtility.getRanDomNum();
		 String orgName = eLib.getExcelData("org", 1, 2) + ranDomNum;
		 

	
		 
		/*step 2 : navigate to Orgnization Page*/ 
		  // driver.findElement(By.linkText("Organizations")).click();
		  HomePage hp=new HomePage(driver);
		  hp.navigateOrg();
		/*step 3 : navigate to create Orgnization Page*/ 
		  // driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		   OrganizationsPage org=new    OrganizationsPage(driver);
		   org.createOrg();
		/*step 4 : create new Orgnization*/
		   //driver.findElement(By.name("accountname")).sendKeys(orgName);
		  // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		   cno.createOrganization(orgName);
		/*step 5 : create new Verify*/  
		  // String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  //if(actSuccessFullMsg.contains(orgName)) {
				//  System.out.println(orgName + "==>Orgnization created successfully==>PASS");
			 // }else {
				  //System.out.println(orgName + "==>Orgnization not created ==>Fail");

		   OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		   String actSuccessFullMsg=oif.getSuccessfullMsg().getText();
		   
		Assert.assertTrue(actSuccessFullMsg.contains(orgName));

			  

	}}
	
	