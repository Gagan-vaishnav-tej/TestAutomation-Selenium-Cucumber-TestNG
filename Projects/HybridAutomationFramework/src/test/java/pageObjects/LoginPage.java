package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-password']") 
	private WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-email']") 
	private WebElement txtemail;
	
	@FindBy(xpath="//input[@value='Login']") 
	private WebElement btnlogin;
	
	public void setEmail(String data)
	{
		txtemail.sendKeys(data);
	}
	
	public void setPassword(String data)
	{
		txtpassword.sendKeys(data);
	}
	
	public void clickLogin()
	{
		btnlogin.click();
	}

}
