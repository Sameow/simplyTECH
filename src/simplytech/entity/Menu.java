package simplytech.entity;

public class Menu {

	int id;
	String username;
	int quantity;
	String item;
	double totalPrice;
	int points;
	int menuID;

	public Menu() {

	}

	public Menu(int id, String username, int quantity, String item,
			double totalPrice, int points) {
		super();
		this.id = id;
		this.username = username;
		this.quantity = quantity;
		this.item = item;
		this.totalPrice = totalPrice;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

}
