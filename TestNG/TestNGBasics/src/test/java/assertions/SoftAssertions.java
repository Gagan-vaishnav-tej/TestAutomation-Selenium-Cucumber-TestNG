package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	@Test
	void hardAssertions()
	{
		System.out.println("Step 1...");
		System.out.println("Step 2...");
		
		System.out.println("...Hard Assertion...");
		Assert.assertEquals(100, 1000); // Hard Assertion
		// (If this step fails subsequent steps will not be executed)
		
		System.out.println("Step 3...");
		System.out.println("Step 4...");
		
		System.out.println(".....Method End.....");
	}
	
	@Test
	void softAssertions()
	{
		System.out.println("Step 1...");
		System.out.println("Step 2...");
		
		
		System.out.println("...Soft Assertion...");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(100, 1000); // Hard Assertion
		// (If this step fails subsequent steps will not be executed)
		
		System.out.println("Step 3...");
		System.out.println("Step 4...");
		
		System.out.println(".....Method End.....");
		
		sa.assertAll();
	}
}
