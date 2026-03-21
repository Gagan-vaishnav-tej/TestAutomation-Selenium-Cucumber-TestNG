package questions.POJOs;

public class Item {
	private String name;
	private double price;
	private int availableQuantity;
	private int reorderLevel;
	public Item(String name, double price, int availableQuantity, int reorderLevel) {
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.reorderLevel = reorderLevel;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public int getReorderLevel() {
		return reorderLevel;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", availableQuantity=" + availableQuantity
				+ ", reorderLevel=" + reorderLevel + "]";
	}
	public void reduceQuantity(int quantity) {
		this.availableQuantity-=quantity;
	}
	
	
}
