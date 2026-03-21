package questions;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import questions.POJOs.Customer;
import questions.POJOs.Item;
import questions.POJOs.Order;
import questions.POJOs.OrderItem;

public class OrderService {
	private List<Item> items = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;
    
    public void addItem(Item item)
    {
    	items.add(item);
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public void placeOrder(Customer customer,List<OrderItem> orderItems)
    {
    	for(OrderItem oi:orderItems)
    	{
    		if(oi.getItem().getAvailableQuantity()<oi.getQuantity())
    		{
    			System.out.println("Insuffient Quantity... for "+oi.getItem().getName());
    			return;
    		}
    	}
    	
    	for (OrderItem oi : orderItems) {
            oi.getItem().reduceQuantity(oi.getQuantity());
        }
    	
    	Order order = new Order(orderCounter++, customer, orderItems);
    	orders.add(order);
    	
    	System.out.println("Order Placed Sucessfully...");
    }
    
    public Item findItemByName(String name)
    {
    	return items.stream()
    			.filter(i->i.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);
    }
    
    public List<Item> findItemsByPrice(double price) {
        return items.stream()
                .filter(i -> i.getPrice() == price)
                .collect(Collectors.toList());
    }
    
    
    public Order getOrderById(int id) {
        return orders.stream()
                .filter(o -> o.getOrderId() == id)
                .findFirst().orElse(null);
    }
    
    public Order getHighestOrder() {
    	orders.sort((o1, o2) -> Double.compare(o2.getTotalAmount(), o1.getTotalAmount()));

        return orders.get(0);
    }

    // Lowest order
    public Order getLowestOrder() {
    	orders.sort((o1, o2) -> Double.compare(o1.getTotalAmount(), o2.getTotalAmount()));

        return orders.get(0);
    }

    // Orders in last week
    public List<Order> getOrdersLastWeek() {
        LocalDate weekAgo = LocalDate.now().minusDays(7);
        return orders.stream()
                .filter(o -> o.getDate().isAfter(weekAgo))
                .collect(Collectors.toList());
    }

    // Orders in last month
    public List<Order> getOrdersLastMonth() {
        LocalDate monthAgo = LocalDate.now().minusMonths(1);
        return orders.stream()
                .filter(o -> o.getDate().isAfter(monthAgo))
                .collect(Collectors.toList());
    }
    
}
