package simplyTECH.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import simplyTECH.DatabaseStatements.DBConnectionManager;


public class Vouchers {
	int id;
	String username;
	String image;
	String title;
	String subtitle;
	String details;	

	public Vouchers(){
		
	}
	
	public Vouchers(int id, String title, String subtitle, String details){
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.details = details;
	}
	
	public Vouchers(String username, String image, String title,
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

}
