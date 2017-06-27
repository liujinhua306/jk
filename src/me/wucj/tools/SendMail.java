package me.wucj.tools;

	import org.apache.commons.mail.EmailException;   
	import org.apache.commons.mail.SimpleEmail;  
	  
	public class SendMail {   
	    public static void email(String title,String content,String mail) {   
	        SimpleEmail email = new SimpleEmail();   
	        email.setTLS(true);       
	        email.setHostName("smtp.163.com");   
	        email.setAuthentication("", ""); // 用户名和密码   
	  
	        try {   
	            email.addTo(mail); // 接收方   
	            email.setFrom(""); // 发送方   
	            email.setSubject(title); // 标题   
	            email.setCharset("utf-8");   
	            email.setMsg(content); // 内容   
	            email.send();   
	            System.out.println("发送邮件"+title+"到"+mail);
	        } catch (EmailException e) {   
	            e.printStackTrace();   
	        }   
	    }  
	    public static void main(String args[]){
	    	email("hello", "test", "");
	    }
	}  
