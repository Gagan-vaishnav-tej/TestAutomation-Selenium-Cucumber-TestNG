package annotations.beforeAndAfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassA {
	
	@BeforeTest
	void beforeTest()
	{
		System.out.println("Before test method...");
	}
	@Test
	void m1()
	{
		System.out.println("Method 1...");
	}
}
