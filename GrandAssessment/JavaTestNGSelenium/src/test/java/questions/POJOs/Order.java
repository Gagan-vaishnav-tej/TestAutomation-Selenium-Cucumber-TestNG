package questions.POJOs;

import java.time.LocalDate;
import java.util.List;

public class Order {
	private int orderId;
	private Customer customer;
	private List<OrderItem> orders;
	private LocalDate date;
	private double totalAmount;
	public Order(int orderId, Customer customer, List<OrderItem> orders) {
		this.orderId = orderId;
		this.customer = customer;
		this.orders = orders;
		this.date = LocalDate.now();
		calculateBill();
	}
	private void calculateBill() {
		totalAmount=0;
		for(OrderItem o:orders)
		{
			totalAmount+=o.getTotal();
		}
		
	}
	public int getOrderId() {
		return orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public List<OrderItem> getOrders() {
		return orders;
	}
	public LocalDate getDate() {
		return date;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", orders=" + orders + ", date=" + date
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
}
