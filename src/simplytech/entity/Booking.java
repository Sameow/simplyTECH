package simplytech.entity;

public class Booking {

	int id;
	String username;
	String title;
	double price;
	int points;

	public Booking() {

	}

	public Booking(int id, String username, String title, double price,
			int points) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.price = price;
		this.points = points;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
