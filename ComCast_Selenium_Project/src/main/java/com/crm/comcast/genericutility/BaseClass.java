package com.crm.comcast.genericutility;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;
/**
 * @author Deepak
 */
public class BaseClass {
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriver driver;


	 @BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	 public void makeDBConnection() {
	  System.out.println("============Make DB Connection============");
	  //dLib.connectToDB();
	 }

	 @BeforeClass(groups = {"smokeTest" , "regressionTest"})
	 public void launchBrowser() throws Throwable {
	  String BROWSER = pLib.readDataFromPropertyFfile("browser");

	  if (BROWSER.equalsIgnoreCase("firefox")) {
	   driver = new FirefoxDriver();
	  } else if (BROWSER.equalsIgnoreCase("chrome")) {
	   driver = new ChromeDriver();
	  } else if (BROWSER.equalsIgnoreCase("ie")) {
	   driver = new InternetExplorerDriver();
	  }
	 }

	 @BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	 public void loginToApplication() throws Throwable {
	  String USERNAME = pLib.readDataFromPropertyFfile("username").trim();
	  String PASSWORD = pLib.readDataFromPropertyFfile("password").trim();
	  String URL = pLib.readDataFromPropertyFfile("url");

	  wLib.waitforPageToLoad(driver);
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(URL);
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApp(USERNAME,PASSWORD);
	  //driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  //driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  //driver.findElement(By.id("submitButton")).click();
	 }

	 @AfterMethod(groups = {"smokeTest" , "regressionTest"})
	 public void logoutOfApplication() throws InterruptedException {
		
	  //WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 // wLib.mouseOver(driver, adminWb);
	  
	 // driver.findElement(By.linkText("Sign Out")).click();
		 HomePage hp=new HomePage(driver);
		 hp.logoutOfApp();
	 }

	 @AfterClass(groups = {"smokeTest" , "regressionTest"})
	 public void closeBrowser() {
	  driver.close();
	 }

	 @AfterSuite(groups = {"smokeTest" , "regressionTest"})
	 public void closeDBConnection() throws SQLException {
	  System.out.println("============Close DB Connection============");
	 // dLib.closeDB();
	 }

	}
	
