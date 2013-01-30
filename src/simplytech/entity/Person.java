package simplytech.entity;

public class Person {
	private int id;
	private String name;
	private String NRIC;
	private String username;
	private String password;
	//private int mobile; 
	private String mobile;
	private String address;
	private String email;
	private String gender;
	private String userType;
	static int count;
	
	public Person(){
		
	}
	
	public Person(int id) {
		super();
		this.id = id;
	}

	public Person(int id, String name,String gender,String NRIC, String username, String password,
			String mobile, String email, String address, String userType) {
		this.id = id;
		System.out.println("Id in person is " + id);
		this.name = name;
		this.gender = gender;
		this.NRIC = NRIC;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.userType = userType;
	}

	public Person(String name,String gender, String NRIC, String username,
			String password, String mobile, String address, String email,String userType){
		super();
		this.name = name;
		this.gender = gender;
		this.NRIC = NRIC;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.userType = userType;
	}
	
	public Person(String changedUsername, String changedMobile,
			String changedGender) {
		this.username=changedUsername;
		this.mobile=changedMobile;
		this.gender=changedGender;
	}
	
	public String getUserType(){
		return userType;
	}
	
	public void setUserType(String userType){
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNRIC() {
		return NRIC;
	}

	public void setNRIC(String NRIC) {
		this.NRIC = NRIC;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

