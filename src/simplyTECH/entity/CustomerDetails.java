package simplyTECH.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import simplyTECH.DatabaseStatements.DBConnectionManager;


public class CustomerDetails extends Person{
	private int ID;
	private String loginName;
	private double extraCharges;
	private int stay;
	private String membership;
	private String checkOut;
	private int points;
	private int doNotDisturb;
	private String alarm;
	private static Connection currentCon = null;
	private static ResultSet rs = null;
	private static ResultSet rs2 = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs1 = null;
	private static PreparedStatement pstmt1 = null;

	public CustomerDetails(){
		
	}
	
	public CustomerDetails(double extraCharges, int stay,
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
}
