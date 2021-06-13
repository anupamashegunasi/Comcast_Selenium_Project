package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class VtigetTest {
	public static void main(String[] args) throws Throwable {
		PropertyfileUtility plib = new PropertyfileUtility();
			String USERNAME = plib.readDataFromPropertyfile("username");
			String PASSWORD = plib.readDataFromPropertyfile("password");
			String URL = plib.readDataFromPropertyfile("url");
			WebDriver driver = new FirefoxDriver();
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
		}
	}


