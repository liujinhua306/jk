package me.wucj.Login.Service.impl;

import java.util.List;

import me.wucj.Login.Dao.LoginDao;
import me.wucj.Login.Service.LoginService;
import me.wucj.emtity.login.Admin;

public class LoginServiceimpl implements LoginService {
	LoginDao logindao;
	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}
	public List LoginService(Admin admin) {
		return logindao.LoginDao(admin);
	}
	public void loginlog(me.wucj.emtity.login.loginlog log) {
		logindao.loginlog(log);
	}

}
