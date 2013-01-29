package simplytech.entity;

public class Announcement {
	String image;
	String type;
	String title;
	String details;
	int id;

	public Announcement(){
		
	}
	
	public Announcement(int id, String title, String details, String image, String type){
		this.id = id;
		this.title = title;
		this.details = details;
		this.image = image;
		this.type = type;
	}
	
	public Announcement(String title, String details, String image, String type){
		this.title = title;
		this.details = details;
		this.image = image;
		this.type= type;
	}
	
	public Announcement(String image, String title, String details) {
		super();
		this.image = image;
		this.title = title;
		this.details = details;
	}

	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	
		
}
