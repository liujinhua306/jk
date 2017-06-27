package me.wucj.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import me.wucj.Monitor.Service.Monitor_Service;
import me.wucj.Timing.Service.Timing_Service;
import me.wucj.emtity.Monitor.Record;
import me.wucj.emtity.Monitor.ip_Monitor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Timing_check {
	private ping ping;
	private Record record = new Record();
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	public void setPing(ping ping) {
		this.ping = ping;
	}

	private Timing_Service timgService;

	public void setTimgService(Timing_Service timgService) {
		this.timgService = timgService;
	}

	@Scheduled(cron = "0/60 * *  * * ? ")
	public void Timing_check() throws Exception {
		System.out.println("執行定時任務");
		List<ip_Monitor> list = timgService.All();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getGet_Post() == 1) {
				if (Post_Get.sendGet(list.get(i).getUrl_ip()) == false) {
					if (list.get(i).getSend_Get_post() == 0) {
						String content = "您好您监控的" + list.get(i).getUrl_ip()
								+ "站点丢失请登录查看";
						SendMail.email("GetPost告警通知", content, list.get(i)
								.getEmail());
						record.setUrl_ip(list.get(i).getUrl_ip());
						record.setDate(df.format(new Date()));
						record.setEvent(0);
						timgService.save(record);
						timgService.modify_get(list.get(i).getId(), 1);
					}
				} else {
					if (list.get(i).getSend_Get_post() == 1) {
						timgService.modify_get(list.get(i).getId(), 0);
						List<Record> list1=timgService.Newest(list.get(i).getUrl_ip(),0);
						String jue= parity.parity(df.format(new Date()), list1.get(0).getDate());
						String content = "站点"+list.get(i).getUrl_ip()+"已恢复正常异常持续时间为:"+jue;
						SendMail.email("站点发送请求已恢复", content, list.get(i)
								.getEmail());
					}
				}
			}
			if (ping.ping(list.get(i).getUrl_ip()) == false) {
				if (list.get(i).getSend_status() == 0) {
					String content = "您好您监控的" + list.get(i).getUrl_ip()
							+ "掉包请登录查看";
					record.setEvent(1);
					record.setUrl_ip(list.get(i).getUrl_ip());
					record.setDate(df.format(new Date()));
					timgService.save(record);
					SendMail.email("ping請求通知", content, list.get(i).getEmail());
					timgService.modify(list.get(i).getId(), 1);
				}
			} else {
				if (list.get(i).getSend_status() == 1) {
					timgService.modify(list.get(i).getId(), 0);
					List<Record> list1= timgService.Newest(list.get(i).getUrl_ip(), 1);
					String jue= parity.parity(df.format(new Date()), list1.get(0).getDate());
					String content="站点"+list.get(i).getUrl_ip()+"恢复正常，异常持续时间:为"+jue;
					SendMail.email("ping請求通知", content, list.get(i).getEmail());
				}
			}
		}
	}
}
