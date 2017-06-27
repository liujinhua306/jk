package me.wucj.Login.Dao;

import java.util.List;

import me.wucj.emtity.login.Admin;
import me.wucj.emtity.login.loginlog;

public interface LoginDao  {
	 List LoginDao(Admin admin);
	 void loginlog(loginlog log);
}
