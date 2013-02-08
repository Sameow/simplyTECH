package simplytech.entity;

public class RoomServices {

	int id;
	String username;
	String service;
	int roomServicesID;

	public RoomServices() {

	}

	public RoomServices(int id, String username, String service) {
		super();
		this.id = id;
		this.username = username;
		this.service = service;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
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

	public int getRoomServicesID() {
		return roomServicesID;
	}

	public void setRoomServicesID(int roomServicesID) {
		this.roomServicesID = roomServicesID;
	}

}