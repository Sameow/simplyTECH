package simplytech.entity;

public class Staff extends Person{
	private String workingSince;
	private String position;
	
	public Staff(String changedUsername, String changedMobile,
			String changedGender, String changedPosition) {
		super(changedUsername, changedMobile, changedGender);
		this.position=changedPosition;
	}
	public Staff() {

	}
	public String getWorkingSince() {
		return workingSince;
	}
	public void setWorkingSince(String workingSince) {
		this.workingSince = workingSince;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
