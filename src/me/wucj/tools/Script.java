package me.wucj.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Script {
	public static String replaceStringP(String source) {
		String result = source;
		if (result.toUpperCase().indexOf("http://".toUpperCase()) == 0) {
			Matcher m = Pattern.compile("http://", Pattern.CASE_INSENSITIVE)
					.matcher(source);
			result = m.replaceAll("");
		}
		if (result.toUpperCase().indexOf("https://".toUpperCase()) == 0) {
			Matcher m = Pattern.compile("https://", Pattern.CASE_INSENSITIVE)
					.matcher(source);
			result = m.replaceAll("");
		}
		if (result.toUpperCase().indexOf("http:\\\\".toUpperCase()) == 0) {
			Matcher m = Pattern.compile("http:\\\\", Pattern.CASE_INSENSITIVE)
					.matcher(source);
			result = m.replaceAll("");
		}
		if (result.toUpperCase().indexOf("https:\\\\".toUpperCase()) == 0) {
			Matcher m = Pattern.compile("https:\\\\", Pattern.CASE_INSENSITIVE)
					.matcher(source);
			result = m.replaceAll("");
		}
	
		return result;
	}
	public static String replace_xss(String url){
		Matcher m = Pattern.compile("script", Pattern.CASE_INSENSITIVE).matcher(url);
		String result = m.replaceAll("");
		Matcher k = Pattern.compile("/", Pattern.CASE_INSENSITIVE).matcher(result);
		String resul1=k.replaceAll("");
		Matcher j = Pattern.compile("<", Pattern.CASE_INSENSITIVE).matcher(resul1);
		String resul2=j.replaceAll("");
		Matcher l = Pattern.compile(">", Pattern.CASE_INSENSITIVE).matcher(resul2);
		String resul3=l.replaceAll("");
		return resul3;
	}
	public static boolean url(String url){
		boolean falg=false;
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		String rexp1="^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$";
		Pattern pattern = Pattern.compile(rexp);
		Pattern pattern1 = Pattern.compile(rexp1);
		if(pattern.matcher(url).matches() || pattern1.matcher(url).matches()){
		return true;
		}
		return falg;
	}
	public static boolean email(String email){
		 String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		 Pattern pattern = Pattern  
	                .compile(check);
		return pattern.matcher(email).matches();  
	}
}
