package dependenciesAndGrouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesDemo {
	
	@Test(priority=1)
	void openApp()
	{
		Assert.assertTrue(true);
		System.out.println("Searching...");
	}
	
	@Test(priority = 2,dependsOnMethods = {"openApp"})
	void login()
	{
		Assert.assertTrue(true);
		System.out.println("Logging In...");
	}
	
	
	@Test(priority=3,dependsOnMethods = {"login"})
	void search()
	{
		Assert.assertTrue(false);
		System.out.println("Searching...");
	}
	
	@Test(priority=3,dependsOnMethods = {"login","search"})
	void advancedSearch()
	{
		Assert.assertTrue(true);
		System.out.println("Advanced Searching...");
	}
	
	@Test(priority = 4,dependsOnMethods= {"login"})
	void logout()
	{
		Assert.assertTrue(true);
		System.out.println("Logging out...");
	}

}
