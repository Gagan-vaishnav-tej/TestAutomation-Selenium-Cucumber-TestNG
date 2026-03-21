package questions.POJOs;

public class OrderItem {
	private Item item;
	private int quantity;
	public OrderItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	public Item getItem() {
		return item;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public double getTotal()
	{
		return item.getPrice()*quantity;
	}
	@Override
	public String toString() {
		return "OrderItem [item=" + item + ", quantity=" + quantity + "]";
	}
	
	
}
