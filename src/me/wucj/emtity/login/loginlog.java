package me.wucj.emtity.login;

import java.text.SimpleDateFormat;
import java.util.Date;

public class loginlog {
	int  id; 	//INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,  
	String date; //DATE NOT NULL,
	String user; //VARCHAR(32) NOT NULL
	String ip;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
