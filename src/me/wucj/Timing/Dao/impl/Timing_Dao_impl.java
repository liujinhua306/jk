package me.wucj.Timing.Dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import me.wucj.Timing.Dao.Timing_Dao;
import me.wucj.emtity.Monitor.Record;
import me.wucj.emtity.Monitor.ip_Monitor;

public class Timing_Dao_impl extends HibernateDaoSupport implements Timing_Dao {
	
	public List All() {
		// TODO Auto-generated method stub
		String hql="from ip_Monitor where state=0";
		return getHibernateTemplate().getSessionFactory().openSession().createQuery(hql).list();
	}

	public boolean send_List(int id) {
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		boolean flag=false;
		//0等于没发送过邮件
		if(ip_monitor.getSend_status()==0){
			flag=true;
		}
		return flag;
	}

	public boolean Get_Post(int id) {
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		boolean flag=false;
		//0为不检测
		if(ip_monitor.getGet_Post()==0){
			flag=true;
		}
		return flag;
	}
	public void modify(int id,int i){
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		ip_monitor.setSend_status(i);
		getHibernateTemplate().update(ip_monitor);
	}

	public void modify_get(int id, int i) {
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		ip_monitor.setSend_Get_post(i);
		getHibernateTemplate().update(ip_monitor);
	}

	public List Newest(String url ,int evet) {
		String hql="FROM Record WHERE url_ip=? AND Event=? ORDER BY id DESC ";
		List list= getHibernateTemplate().getSessionFactory().openSession().createQuery(hql).setString(0, url).setInteger(1, evet).setFirstResult(0).setMaxResults(1).list();
		return list;
	}

	public boolean save(Record record) {
		// TODO Auto-generated method stub
		try{
			getHibernateTemplate().save(record);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
