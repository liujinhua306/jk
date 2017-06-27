package me.wucj.tools;

import java.text.SimpleDateFormat;

public class parity {
	public static String parity(String now,String date){
		try{
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 java.util.Date now1 =df.parse(now);  
		 java.util.Date date1=df.parse(date);  
		  long l =now1.getTime()-date1.getTime();  
		 long day=l/(24*60*60*1000);  
		  long hour=(l/(60*60*1000)-day*24);  
		 long min=((l/(60*1000))-day*24*60-hour*60);  
		  long s=(l/1000-day*24*60*60-hour*60*60-min*60);  
		  return ""+day+"天"+hour+"小时"+min+"分"+s+"秒";
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
