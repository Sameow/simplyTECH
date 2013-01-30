package simplytech.entity;

public class CustomerVouchers {
	int id;
	int vouchersId;
	String username;
	String image;
	String title;
	String subtitle;
	String details;	
	String expiryDate;

	public CustomerVouchers(){
		
	}
	
	public CustomerVouchers(int id, String title, String subtitle, String details, String image, String expiryDate){
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.details = details;
		this.image = image;
		this.expiryDate = expiryDate;
	}
	
	public CustomerVouchers(int id, int vouchersId, String title, String subtitle, String details, String image){
		this.id = id;
		this.vouchersId = vouchersId;
		this.title = title;
		this.subtitle = subtitle;
		this.details = details;
		this.image = image;
	}
	
	
	public CustomerVouchers(String username, String image, String title,
			String subtitle, String details) {
		super();
		this.username = username;
		this.image = image;
		this.title = title;
		this.subtitle = subtitle;
		this.details = details;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public int getVouchersId() {
		return vouchersId;
	}

	public void setVouchersId(int vouchersId) {
		this.vouchersId = vouchersId;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
