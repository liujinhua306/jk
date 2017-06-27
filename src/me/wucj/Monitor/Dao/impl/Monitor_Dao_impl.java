package me.wucj.Monitor.Dao.impl;


import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import me.wucj.Monitor.Dao.Monitor_Dao;
import me.wucj.emtity.Monitor.ip_Monitor;

public class Monitor_Dao_impl extends HibernateDaoSupport implements Monitor_Dao {
	
	//查询监控网站列表
	public List main_All(int startrow,int pagesize) {
		// TODO Auto-generated method stub
		String hql="from ip_Monitor";
		return getHibernateTemplate().getSessionFactory().openSession().createQuery(hql).setFirstResult(startrow).setMaxResults(pagesize).list();
	}
	//添加url
	public boolean main_Add(ip_Monitor ip) {
		try{
		getHibernateTemplate().save(ip);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	//修改url
	public boolean main_modify(int id,String modify_ip,String modify_email) {
		try{
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		if(ip_monitor!=null){
			ip_monitor.setUrl_ip(modify_ip);
			ip_monitor.setEmail(modify_email);
			getHibernateTemplate().update(ip_monitor);
			return true;
		}
		return false;
		}catch(Exception e){
			return false;
		}
	}
	//删除url
	public boolean main_Del(int id) {
		try{
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		getHibernateTemplate().delete(ip_monitor);
		return true;
		}catch(Exception e){
		return false;
		}
	}
	//查看发送记录
	public List main_Record() {
		String hql="FROM Record ORDER BY id desc";
		return getHibernateTemplate().getSessionFactory().openSession().createQuery(hql).setFirstResult(0).setMaxResults(5).list();
	}
	public ip_Monitor main_Query_modify(int id) {
		String hql="select id,url_ip,email from ip_Monitor where id=?";
		return getHibernateTemplate().get(ip_Monitor.class, id);
	}
	//开启/关闭get_post请求
	public boolean main_Requestswitch(int id) {
		try{
		ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
		if(ip_monitor!=null){
		if(ip_monitor.getGet_Post()==0){
			ip_monitor.setGet_Post(1);
		}else{
			ip_monitor.setGet_Post(0);
		}}
		getHibernateTemplate().update(ip_monitor);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	//开启/关闭
		public boolean main_State(int id) {
			try{
 			ip_Monitor ip_monitor= getHibernateTemplate().get(ip_Monitor.class, id);
			if(ip_monitor!=null){
			if(ip_monitor.getState()==0){
				ip_monitor.setState(1);
				getHibernateTemplate().update(ip_monitor);
				return false;
			}else{
				ip_monitor.setState(0);
				getHibernateTemplate().update(ip_monitor);
				return true;
			}}
			}catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
	//分頁查詢計算总数
		public int COUNT(){
			String hql="SELECT COUNT(*) FROM ip_Monitor";

		    Query query = getHibernateTemplate().getSessionFactory().openSession().createQuery(hql);  
		    int count = ((Number)query.uniqueResult()).intValue();  
			return count;
		}
	
}
