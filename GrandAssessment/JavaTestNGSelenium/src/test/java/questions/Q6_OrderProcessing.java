package questions;

import java.util.ArrayList;
import java.util.List;

import questions.POJOs.Customer;
import questions.POJOs.Item;
import questions.POJOs.OrderItem;

public class Q6_OrderProcessing {
	public static void main() {
		OrderService service = new OrderService();
		
		Item i1 = new Item("Laptop", 50000, 10, 2);
        Item i2 = new Item("Phone", 20000, 5, 1);

        service.addItem(i1);
        service.addItem(i2);

        Customer c1 = new Customer("Ravi", "Hyderabad", "9999999999", "ravi@gmail.com");
        service.addCustomer(c1);


        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(i1, 1));
        orderItems.add(new OrderItem(i2, 1));

        service.placeOrder(c1, orderItems);

        System.out.println("Highest Order: " + service.getHighestOrder());
        
        System.out.println("Lowest Order: " + service.getLowestOrder());

        System.out.println("Orders last week:");
        System.out.println(service.getOrdersLastWeek());
        
        System.out.println("Orders last month:");
        System.out.println(service.getOrdersLastMonth());
    }
}
