package dependenciesAndGrouping.grouping;

import org.testng.annotations.Test;

public class PaymentTests {
	@Test(groups= {"sanity","regression","functional"})
	void paymentInRupees()
	{
		System.out.println("Payment in Rupees...");
	}
	
	@Test(groups= {"sanity","regression","functional"})
	void paymentInDollars()
	{
		System.out.println("Payment in Dollars...");
	}
}
