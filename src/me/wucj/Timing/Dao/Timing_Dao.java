package me.wucj.Timing.Dao;

import java.util.List;

import me.wucj.emtity.Monitor.Record;
import me.wucj.emtity.Monitor.ip_Monitor;

public interface Timing_Dao {
	//查询开启监控的url检测
		public List All();
	//查询是否已经发送邮件
		public boolean send_List(int id);
	//查询是否发送get_post请求
		public boolean Get_Post(int id);
	//查询id修改
		public void modify(int id,int i);
	//修改get_post发送邮件状态
		public void modify_get(int id,int i);
	//查询最新报警记录
		public List Newest(String url,int evet);
	//保存最新日志记录
		public boolean save(Record record);
}
