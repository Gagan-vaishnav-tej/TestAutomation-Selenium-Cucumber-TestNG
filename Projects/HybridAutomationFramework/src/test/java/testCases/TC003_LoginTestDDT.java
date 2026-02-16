package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseTest{
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups="DataDriven")
	void verify_login(String email,String password,String expectedResult)
	{
		try
		{
			logger.info("******  Started TC003_LoginTestDDT  *****");
			HomePage homepage= new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickLogin();
			
			LoginPage loginpage = new LoginPage(driver);
			loginpage.setEmail(email);
			loginpage.setPassword(password);
			loginpage.clickLogin();
			
			MyAccountPage myaccountpage = new MyAccountPage(driver);
			boolean isDisplayed = myaccountpage.isMyAccountDisplayed();
			if(expectedResult.equals("Valid"))
			{
				if(isDisplayed)
				{
					myaccountpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.fail();
				}
			}
			else
			{
				if(isDisplayed)
				{
					myaccountpage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******  Finished TC003_LoginTestDDT  *****");
	}
}
