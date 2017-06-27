package me.wucj.Timing.Service.impl;

import java.util.List;

import me.wucj.Timing.Dao.Timing_Dao;
import me.wucj.Timing.Service.Timing_Service;
import me.wucj.emtity.Monitor.Record;

public class Timing_Service_impl implements Timing_Service {
	private Timing_Dao timing_dao;
	public void setTiming_dao(Timing_Dao timing_dao) {
		this.timing_dao = timing_dao;
	}
	public List All() {
		// TODO Auto-generated method stub
		return timing_dao.All();
	}

	public boolean send_List(int id) {
		// TODO Auto-generated method stub
		return timing_dao.send_List(id);
	}

	public boolean Get_Post(int id) {
		// TODO Auto-generated method stub
		return timing_dao.Get_Post(id);
	}
	public void modify(int id, int i) {
		timing_dao.modify(id, i);
		
	}
	public void modify_get(int id, int i) {
		timing_dao.modify_get(id, i);
	}
	public List Newest(String url,int evet) {
		// TODO Auto-generated method stub
		return timing_dao.Newest(url,evet);
	}
	public boolean save(Record record) {
		// TODO Auto-generated method stub
		return timing_dao.save(record);
	}

}
