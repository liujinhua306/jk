package me.wucj.Monitor.Service.impl;

import java.util.List;

import me.wucj.Monitor.Dao.Monitor_Dao;
import me.wucj.Monitor.Service.Monitor_Service;
import me.wucj.emtity.Monitor.ip_Monitor;

public class Monitor_Service_impl implements Monitor_Service {
	private Monitor_Dao monitorDao;
	public void setMonitorDao(Monitor_Dao monitordao) {
		this.monitorDao = monitordao;
	}
	public List main_All(int startrow,int pagesize) {
		// TODO Auto-generated method stub
		return monitorDao.main_All(startrow,pagesize);
	}

	public boolean main_Add(ip_Monitor ip) {
		// TODO Auto-generated method stub
		return monitorDao.main_Add(ip);
	}

	public boolean main_modify(int id,String url_ip,String modify_email) {
		// TODO Auto-generated method stub
		return monitorDao.main_modify(id, url_ip, modify_email);
	}

	public boolean main_Del(int id) {
		// TODO Auto-generated method stub
		return monitorDao.main_Del(id);
	}

	public List main_Record() {
		// TODO Auto-generated method stub
		return monitorDao.main_Record();
	}
	public ip_Monitor main_Query_modify(int id) {
		// TODO Auto-generated method stub
		return monitorDao.main_Query_modify(id);
	}
	public boolean main_Requestswitch(int id) {
		return monitorDao.main_Requestswitch(id);
	}
	public boolean main_State(int id) {
		return monitorDao.main_State(id);
	}
	public int COUNT() {
		// TODO Auto-generated method stub
		return monitorDao.COUNT();
	}
	
}
