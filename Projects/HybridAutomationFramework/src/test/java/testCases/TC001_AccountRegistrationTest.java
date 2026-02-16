package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseTest;

public class TC001_AccountRegistrationTest extends BaseTest{
	@Test(groups = {"Regression","Master"})
	void verifyAccountRegistration()
	{
		try
		{
			logger.info("****** Started TC001_AccountRegistrationTest ******");
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickRegister();
			
			logger.info("CLicked on Register Page");
			RegisterPage registerPage = new RegisterPage(driver);
			
			logger.info("Filling Details");
			registerPage.setfirstName(randomString());
			registerPage.setlastName(randomString());
			registerPage.setemail(randomString()+"@gmail.com");
			registerPage.settelephone(randomNumber());
			
			String password = randomalphaNumeric();
			registerPage.setpassword(password);
			registerPage.setconfirmpassword(password);
			
			registerPage.clickprivacy();
			registerPage.clickcontinue();
			
			if(registerPage.getVerificationMessage().equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
				
			}
			else
			{
				logger.error("Error log....");
				logger.debug("Debug log....");
				Assert.fail();
			}
			//Assert.assertEquals("Your Account Has Been Created!",registerPage.getVerificationMessage());
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****** Finished TC001_AccountRegistrationTest ******");
	}
}
