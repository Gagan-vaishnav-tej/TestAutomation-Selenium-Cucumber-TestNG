package pageObjectModel;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(how = How.XPATH,using="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(tagName = "a")
	List<WebElement> links;
	
	void setUsername(String data)
	{
		username.sendKeys(data);
	}
	
	void setPassword(String data)
	{
		password.sendKeys(data);
	}
	
	void clickLogin()
	{
		login.click();
	}

}
