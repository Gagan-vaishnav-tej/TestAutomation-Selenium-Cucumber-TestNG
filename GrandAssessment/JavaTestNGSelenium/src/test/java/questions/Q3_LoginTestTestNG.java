package questions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q3_LoginTestTestNG {
	
	WebDriver driver;
	By usernameInput = By.xpath("//input[@id='username']");
	By passwordInput = By.xpath("//input[@id='password']");
	By submitButton = By.xpath("//button[@id='submit']");
	
	@BeforeMethod
	public void openbrowser()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	@Test(priority = 1)
	public void sucessfulLogin()
	{
		driver.findElement(usernameInput).sendKeys("student");
		driver.findElement(passwordInput).sendKeys("Password123");
		driver.findElement(submitButton).click();
		Assert.assertNotEquals("https://practicetestautomation.com/practice-test-login/", driver.getCurrentUrl());
	}
	
	@Test(priority = 2)
	public void unsucessfulLogin()
	{
		driver.findElement(usernameInput).sendKeys("student123");
		driver.findElement(passwordInput).sendKeys("Password123");
		driver.findElement(submitButton).click();
		Assert.assertEquals("https://practicetestautomation.com/practice-test-login/", driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
