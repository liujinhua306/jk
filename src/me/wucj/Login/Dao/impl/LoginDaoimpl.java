package me.wucj.Login.Dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import me.wucj.Login.Dao.LoginDao;
import me.wucj.emtity.login.Admin;
import me.wucj.emtity.login.loginlog;

public class LoginDaoimpl extends HibernateDaoSupport implements LoginDao  {
	public List LoginDao(Admin admin) {
		String hql="from Admin where user=? and password=?";
		return getHibernateTemplate().getSessionFactory().openSession().createQuery(hql).setString(0, admin.getUser()).setString(1, admin.getPassword()).list();
	}
	public void loginlog(loginlog log){
		getHibernateTemplate().save(log);
	}
	
}
