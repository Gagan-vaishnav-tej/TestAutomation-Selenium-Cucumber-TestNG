
package basics;
/*
	1) Open App
	2) Login
	3) Logout
*/



import org.testng.annotations.Test;

public class FirstTestCase {
	
	@Test(priority=0)
	void openApp()
	{
		System.out.println("Opening Application...");
	}
	
	@Test(priority=-1)
	void login()
	{
		System.out.println("Login to Application...");
	}
	
	@Test(priority=1)
	void logout()
	{
		System.out.println("Logout from Application...");
	}

}
