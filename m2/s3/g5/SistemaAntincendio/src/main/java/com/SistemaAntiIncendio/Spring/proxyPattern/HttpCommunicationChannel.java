package com.SistemaAntiIncendio.Spring.proxyPattern;

public class HttpCommunicationChannel implements CommunicationChannel {
	
	 private String url;

	 public HttpCommunicationChannel(String url) {
		
		 this.url = url;
		 
	 }
	    
	 @Override
	 public void sendAlarmData(String data) {
		 
		 System.out.println("Sending data to URL: " + url + " - Data: " + data);
	 }
}
