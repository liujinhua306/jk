package me.wucj.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Post_Get {
	public static boolean sendGet(String url) {  
		try{
		URL realUrl = new URL("http://" + url);
		
		// 打开和URL之间的连接
		URLConnection connection = realUrl.openConnection();
		// 设置通用的请求属性
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		// 建立实际的连接
		connection.connect();
		// 获取所有响应头字段
		Map<String, List<String>> map = connection.getHeaderFields();
		// 遍历所有的响应头字段
		List<String> name = null;
		for (String key : map.keySet()) {
			name = map.get(key);
			break;
		}
		if (name.get(0).contains("200")) {
			return true;
		}
		return false;
		}catch(Exception e){
			System.out.println("发送请求失败");
			return false;
		}
	}
}
