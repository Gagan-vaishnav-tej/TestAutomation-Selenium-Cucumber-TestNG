package dependenciesAndGrouping.grouping;

import org.testng.annotations.Test;

public class LoginTests {
	
	@Test(groups= {"sanity"})
	void loginWithEmail()
	{
		System.out.println("Login with Email...");
	}
	
	@Test(groups= {"sanity"})
	void loginWithFacebook()
	{
		System.out.println("Login with Facebook...");
	}
	
	@Test(groups= {"sanity"})
	void loginWithInstagram()
	{
		System.out.println("Login with Instagram...");
	}
}
