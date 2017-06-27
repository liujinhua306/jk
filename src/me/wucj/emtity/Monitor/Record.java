package me.wucj.emtity.Monitor;

import java.util.Date;

public class Record {
	private int  id;// 	INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,
	private String url_ip;// varchar(32) ,
	private String date;// date not null
	private int Event;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl_ip() {
		return url_ip;
	}
	public void setUrl_ip(String url_ip) {
		this.url_ip = url_ip;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getEvent() {
		return Event;
	}
	public void setEvent(int event) {
		Event = event;
	}

}
