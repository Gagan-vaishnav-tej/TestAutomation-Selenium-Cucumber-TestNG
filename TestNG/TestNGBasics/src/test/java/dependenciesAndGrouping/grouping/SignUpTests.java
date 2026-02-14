package dependenciesAndGrouping.grouping;

import org.testng.annotations.Test;

public class SignUpTests {
	
	@Test(groups= {"regression"})
	void signupWithEmail()
	{
		System.out.println("Signup with Email...");
	}
	
	@Test(groups= {"regression"})
	void signupWithFacebook()
	{
		System.out.println("Signup with Facebook...");
	}
	
	@Test(groups= {"regression"})
	void signupWithInstagram()
	{
		System.out.println("Signup with Instagram...");
	}
}
