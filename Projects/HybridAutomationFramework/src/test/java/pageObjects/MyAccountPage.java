package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	private WebElement divmyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	private WebElement btnlogout;
	
	public boolean isMyAccountDisplayed()
	{
		try
		{
			return divmyAccount.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		btnlogout.click();
	}
}
