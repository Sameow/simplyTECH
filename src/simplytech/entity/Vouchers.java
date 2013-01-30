package simplytech.entity;

public class Vouchers {
	int id;
	String type;
	String title;
	String subtitle;
	String details;
	String image;
	int pointsRequired;
	
	public Vouchers(){
		
	}
	
	public Vouchers (String type, String title, String subtitle, String details, String image, int pointsRequired){
		this.type = type;
		this.title = title;
		this.subtitle = subtitle;
		this.details = details;
		this.image = image;
		this.pointsRequired = pointsRequired;
	}

	
	public Vouchers (String title, String subtitle, String details, String image, int pointsRequired){
		this.title = title;
		this.subtitle = subtitle;
		this.details = details;
		this.image = image;
		this.pointsRequired = pointsRequired;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPointsRequired() {
		return pointsRequired;
	}

	public void setPointsRequired(int pointsRequired) {
		this.pointsRequired = pointsRequired;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
