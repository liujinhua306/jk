package me.wucj.Login.Service;

import java.util.List;

import me.wucj.emtity.login.Admin;
import me.wucj.emtity.login.loginlog;

public interface LoginService {
	List LoginService(Admin admin);
	void loginlog(loginlog log);
}
