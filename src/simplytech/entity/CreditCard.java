package simplytech.entity;

public class CreditCard{

	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private String expiryDate;
	private String cardHolderName;
	private String country;
	private int CVC;
	private int id;
	private String streetAddress;
	private String cardType;
	int count;
	
	public CreditCard(){
		
	}
	
	public CreditCard(String cardNumber, int expiryMonth, int expiryYear, String expiryDate,
			String cardHolderName, String country, int CVC, String streetAddress,
			String cardType){
		super();
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.expiryDate = expiryDate;
		this.cardHolderName = cardHolderName;
		this.country = country;
		this.CVC = CVC;
		this.streetAddress = streetAddress;
		this.cardType = cardType;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String Country) {
		this.country = Country;
	}
	public int getCVC() {
		return CVC;
	}
	public void setCVC(int CVC) {
		this.CVC = CVC;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCardType(){
		return cardType;
	}
	public void setCardType(String cardType){
		this.cardType = cardType;
	}	
}
