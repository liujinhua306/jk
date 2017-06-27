package me.wucj.tools;

import java.net.InetAddress;

public class ping {
	public boolean ping(String ip){
		try{
		 InetAddress address;
		   address = InetAddress.getByName(ip);
		   return address.isReachable(3000);
		}catch(Exception e){
			System.out.println("ping不通");
			return false;
		}
	}
}