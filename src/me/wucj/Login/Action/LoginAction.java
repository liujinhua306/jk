package me.wucj.Login.Action;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import me.wucj.Login.Service.LoginService;
import me.wucj.emtity.login.Admin;
import me.wucj.emtity.login.loginlog;
import me.wucj.tools.Ip;
import me.wucj.tools.md5;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private LoginService loginservice;
	private Admin admin;
	private JSONArray json;
	private HttpServletRequest req; 
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}
	public void setJson(JSONArray json) {
		this.json = json;
	}
	public JSONArray getJson() {
		return json;
	}
	public String login() {
		admin.setPassword(md5.getMD5(admin.getPassword()));
		//System.out.println(admin.getPassword());
		List<Admin> list=loginservice.LoginService(admin);
		List<String> list1=new ArrayList<String>();
		if(list.size()!=0){
			ActionContext.getContext().getSession().put("admin", admin);
			loginlog log=new loginlog();
			log.setDate(df.format(new Date()));// new Date()为获取当前系统时间
			req= ServletActionContext.getRequest();
			log.setIp(Ip.getIp2(req));
			System.out.println(df.format(new Date()));
			log.setUser(admin.getUser());
			loginservice.loginlog(log);
			list1.add("200");
		}else{
		list1.add("用户名或者密码错误！！！");
		}
		json=JSONArray.fromObject(list1);
		return "success";
	}
}
