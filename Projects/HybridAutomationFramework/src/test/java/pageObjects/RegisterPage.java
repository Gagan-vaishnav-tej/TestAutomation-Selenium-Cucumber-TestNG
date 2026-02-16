package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage
{
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtcfrmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btnprivacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtCfrmMessage;
	
	public void setfirstName(String data)
	{
		txtfirstName.sendKeys(data);
	}
	
	public void setlastName(String data)
	{
		txtlastName.sendKeys(data);
	}
	
	public void setemail(String data)
	{
		txtemail.sendKeys(data);
	}
	
	public void settelephone(String data)
	{
		txttelephone.sendKeys(data);
	}
	
	public void setpassword(String data)
	{
		txtpassword.sendKeys(data);
	}
	
	public void setconfirmpassword(String data)
	{
		txtcfrmpassword.sendKeys(data);
	}
	
	public void clickprivacy()
	{
		btnprivacypolicy.click();
	}
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	
	public String getVerificationMessage()
	{
		try
		{
			return txtCfrmMessage.getText();
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
