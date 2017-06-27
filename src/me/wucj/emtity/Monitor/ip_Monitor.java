package me.wucj.emtity.Monitor;

import java.util.Date;

public class ip_Monitor {
 	private int id; 	//INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,  
 	private String url_ip;// varchar(50) not null,
 	private String date;
 	private int state;// int DEFAULT 0,//状态是否正常，0为正常1为不正常
 	private int Send_status;// int DEFAULT 0,//0为未发送1为已发送
 	private int Get_Post;	//监控是否发送get_Post请求
 	private String email;
 	private int Send_Get_post;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSend_status() {
		return Send_status;
	}
	public void setSend_status(int send_status) {
		Send_status = send_status;
	}
	public int getGet_Post() {
		return Get_Post;
	}
	public void setGet_Post(int get_Post) {
		Get_Post = get_Post;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSend_Get_post() {
		return Send_Get_post;
	}
	public void setSend_Get_post(int send_Get_post) {
		Send_Get_post = send_Get_post;
	}

	
}
