package me.wucj.Monitor.Service;

import java.util.List;

import me.wucj.emtity.Monitor.ip_Monitor;

public interface Monitor_Service {
	//查看监控的url表
	public List main_All(int startrow,int pagesize);
	//添加url
	public boolean main_Add(ip_Monitor ip);
	//修改url
	public boolean main_modify(int id,String ip,String modify_email);
	//删除Del
	public boolean main_Del(int id);
	//查看发送短信记录
	public List main_Record();
	//查找修改的url
	public ip_Monitor main_Query_modify(int id);
	//get_Post请求开关
	public boolean main_Requestswitch(int id);
	//监控开关
	public boolean main_State(int id);
	//分页计算总数
	public int COUNT();
}
