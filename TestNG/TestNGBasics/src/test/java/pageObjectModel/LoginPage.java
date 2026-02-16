package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	By text_locator = By.xpath("//input[@placeholder='Username']");
	By password_locator = By.xpath("//input[@placeholder='Password']");
	By login_locator = By.xpath("//button[@type='submit']");
	
	void setUsername(String data)
	{
		driver.findElement(text_locator).sendKeys(data);
	}
	
	void setPassword(String data)
	{
		driver.findElement(password_locator).sendKeys(data);
	}
	
	void clickLogin()
	{
		driver.findElement(login_locator).click();
	}

}
