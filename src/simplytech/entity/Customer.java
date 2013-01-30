package simplytech.entity;

public class Customer extends Person{
	private int ID;
	private String loginName;
	private double extraCharges;
	private int stay;
	private String membership;
	private String checkOut;
	private int points;
	private int doNotDisturb;
	private String alarm;
	private String roomNumber;
	
	public Customer(){
		
	}
	
	public Customer(int id, String name,String gender,String NRIC, String username, String password,
			String mobile, String email, String address, String userType) {
		super(id, name, gender, NRIC, username, password, mobile, email, address, userType);
		this.setId(id);
		}
	
	public Customer(double extraCharges, int stay,
			String membership, String checkOut, int points, int doNotDisturb,
			String alarm) {
		super();
		this.extraCharges = extraCharges;
		this.stay = stay;
		this.membership = membership;
		this.checkOut = checkOut;
		this.points = points;
		this.doNotDisturb = doNotDisturb;
		this.alarm = alarm;
	}
	
	public Customer(int iD, String loginName, double extraCharges,
			int stay, String membership, String checkOut, int points,
			int doNotDisturb, String alarm, String roomNumber) {
		super();
		ID = iD;
		this.loginName = loginName;
		this.extraCharges = extraCharges;
		this.stay = stay;
		this.membership = membership;
		this.checkOut = checkOut;
		this.points = points;
		this.doNotDisturb = doNotDisturb;
		this.alarm = alarm;
		this.roomNumber = roomNumber;
	}

	
	public int getId(){
		return ID;
	}
	
	public void setId(int ID){
		this.ID = ID;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public double getExtraCharges() {
		return extraCharges;
	}
	public void setExtraCharges(double extraCharges) {
		this.extraCharges = extraCharges;
	}
	public int getStay() {
		return stay;
	}
	public void setStay(int stay) {
		this.stay = stay;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getDoNotDisturb() {
		return doNotDisturb;
	}
	public void setDoNotDisturb(int doNotDisturb) {
		this.doNotDisturb = doNotDisturb;
	}
	public String getAlarm() {
		return alarm;
	}
	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}	
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	
}
