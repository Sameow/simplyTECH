package simplytech.entity;

public class AlarmClock {

	int id;
	String username;
	int hour;
	int minute;

	public AlarmClock() {

	}

	public AlarmClock(int id, String username, int hour, int minute) {
		super();
		this.id = id;
		this.username = username;
		this.hour = hour;
		this.minute = minute;
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

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

}
