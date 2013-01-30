package simplytech.entity;

public class AccommodationsEntity {

	private String accoSuite;
	private int id;
	private int accoDay;
	private int accoRoom;
	private double accoPrice;
	private String accoCheckOut;
	private String accoRoomNumber;
	public AccommodationsEntity(){
		
	}
	public AccommodationsEntity(int id, String accoSuite, int accoDay, int accoRoom, double accoPrice, String accoCheckout, String roomNumber){
		this.accoSuite = accoSuite;
		this.accoDay = accoDay;
		this.accoRoom = accoRoom;
		this.accoPrice = accoPrice;
		this.accoCheckOut = accoCheckout;
		this.id = id;
		this.accoRoomNumber = roomNumber;
	}
	public String getAccoRoomNumber(){
		return accoRoomNumber;
	}
	public void setAccoRoomNumber(String accoRoomNumber){
		this.accoRoomNumber = accoRoomNumber;
	}
	public String getAccoCheckOut(){
		return accoCheckOut;
	}
	
	public void setAccoCheckOut(String accoCheckOut){
		this.accoCheckOut = accoCheckOut;
	}
	public String getAccoSuite() {
		return accoSuite;
	}

	public void setAccoSuite(String accoSuite) {
		this.accoSuite = accoSuite;
	}

	public int getAccoDay() {
		return accoDay;
	}

	public void setAccoDay(int accoDay) {
		this.accoDay = accoDay;
	}

	public int getAccoRoom() {
		return accoRoom;
	}

	public void setAccoRoom(int accoRoom) {
		this.accoRoom = accoRoom;
	}

	public double getAccoPrice() {
		return accoPrice;
	}

	public void setAccoPrice(double accoPrice) {
		this.accoPrice = accoPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
