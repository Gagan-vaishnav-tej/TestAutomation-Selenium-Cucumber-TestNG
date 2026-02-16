package dataproviderAndParallelTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterTest {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String browser)
	{
		switch(browser.toLowerCase())
		{
			case "chrome":driver = new ChromeDriver();break;
			case "edge":driver = new EdgeDriver();break;
			default: return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}
	
	@Test(priority = 1)
	void testlogo()
	{
		Assert.assertEquals("Account Login", driver.getTitle());
	}
	
	@Test(priority = 2)
	void testURL()
	{
		Assert.assertEquals("https://tutorialsninja.com/demo/index.php?route=account/login", driver.getCurrentUrl());
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
}
