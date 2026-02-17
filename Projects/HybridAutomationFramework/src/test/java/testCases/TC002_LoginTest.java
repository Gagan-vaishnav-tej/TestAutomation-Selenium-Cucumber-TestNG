package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginTest extends BaseTest{
	@Test(groups = {"Sanity","Master"})
	void verify_login()
	{
		try
		{
			logger.info("******  Started TC002_LoginTest  *****");
			HomePage homepage= new HomePage(getDriver());
			homepage.clickMyAccount();
			homepage.clickLogin();
			
			LoginPage loginpage = new LoginPage(getDriver());
			loginpage.setEmail(properties.getProperty("email"));
			loginpage.setPassword(properties.getProperty("password"));
			loginpage.clickLogin();
			
			MyAccountPage myaccountpage = new MyAccountPage(getDriver());
			boolean isDisplayed = myaccountpage.isMyAccountDisplayed();
			if(isDisplayed) 
			{
				Assert.assertTrue(isDisplayed);
			}
			else {
				Assert.fail();
			}
		}catch(Exception e)
		{
//			Assert.fail();
			System.out.println(e);
		}
		logger.info("******  Finished TC002_LoginTest  *****");
	}
}
