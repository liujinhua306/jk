package me.wucj.Monitor.Action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import me.wucj.Monitor.Service.Monitor_Service;
import me.wucj.emtity.Monitor.ip_Monitor;
import me.wucj.tools.Script;

public class Monitor_Action extends ActionSupport {
	private Monitor_Service monitorservice;
	private ip_Monitor ip_Monitor;
	private int startrow;// 分页查询
	private int pagesize;// 分页查询
	private int id;		//獲取操作id
	private String modify_email; //修改的email
	private String modify_url;//修改的url
	public String getModify_email() {
		return modify_email;
	}

	public void setModify_email(String modify_email) {
		this.modify_email = modify_email;
	}

	public String getModify_url() {
		return modify_url;
	}

	public void setModify_url(String modify_url) {
		this.modify_url = modify_url;
	}

	public Monitor_Service getMonitorservice() {
		return monitorservice;
	}

	public void setMonitorservice(Monitor_Service monitorservice) {
		this.monitorservice = monitorservice;
	}

	public ip_Monitor getIp_Monitor() {
		return ip_Monitor;
	}

	public void setIp_Monitor(ip_Monitor ip_Monitor) {
		this.ip_Monitor = ip_Monitor;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// 查看监控的url表
	public String main_All() throws Exception {
		List<ip_Monitor> list;
		list = monitorservice.main_All(startrow, pagesize);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}

	// 添加url
	public String main_Add() throws Exception {
		List<String> list = new ArrayList<String>();
		if(Script.url(this.ip_Monitor.getUrl_ip()) && Script.email(this.ip_Monitor.getEmail())){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		ip_Monitor.setDate(df.format(new Date()));
		String url= Script.replaceStringP(ip_Monitor.getUrl_ip());
		String url_=Script.replace_xss(url); 
		ip_Monitor.setUrl_ip(url_);
		String url1= Script.replaceStringP(ip_Monitor.getEmail());
		String url1_=Script.replace_xss(url1); 
		ip_Monitor.setEmail(url1_);
		boolean flag= monitorservice.main_Add(ip_Monitor);
		if(flag=true){
			list.add("添加成功");
		}else{
			list.add("添加失败");
		}
		}
		list.add("输入不是正确网址跟");
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}

	// 修改url
	public String main_modify() throws Exception {
		List<String> list=new ArrayList<String>();
		if(Script.url(this.modify_url) && Script.email(this.modify_email)){
		String url= Script.replaceStringP(this.modify_url);
		String url_=Script.replace_xss(url); 
		modify_url=url_;
		System.out.println("test");
		System.out.println(url_);
		String url1= Script.replaceStringP(this.modify_email);
		String url1_=Script.replace_xss(url1); 
		modify_email=url1_;
		boolean flag= monitorservice.main_modify(this.id,url_, url1_);
		if(flag==true){
			list.add("修改成功");
		}else{
			list.add("修改失败");
		}
		}else{
			list.add("输入的不是正确的url或者ip");
		}
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}

	// 删除Del
	public String main_Del()throws Exception {
		boolean flag= monitorservice.main_Del(id);
		List<String> list=new ArrayList<String>();
		if(flag==true){
			list.add("刪除成功");
		}else{
			list.add("刪除失败");
		}
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}

	// 查看发送短信记录
	public String main_Record() throws Exception {
		List<ip_Monitor> list = monitorservice.main_Record();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}

	// 通过id查询然后修改
	public String main_Query_modify() throws Exception {
		ip_Monitor ip_monitor = monitorservice.main_Query_modify(id);
		List<ip_Monitor> list=new ArrayList<ip_Monitor>();
		list.add(ip_monitor);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}

	// get_Post请求开关
	public String main_Requestswitch() throws Exception {
		boolean judge = monitorservice.main_Requestswitch(id);
		List<String> list=new ArrayList<String>();
		if(judge==true){
			list.add("修改成功");
		}else{
			list.add("修改失败");
		}
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}
	public String main_State()throws Exception{
		boolean judge = monitorservice.main_State(id);
		List<String> list=new ArrayList<String>();
		if(judge==true){
			list.add("开启");
		}else{
			list.add("关闭");
		}
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}
	public String main_COUNT() throws Exception{
		List list=new ArrayList();
		list.add(monitorservice.COUNT());
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		return null;
	}
}
