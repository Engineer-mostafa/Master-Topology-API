package com.example.Topology.models;

public class Helper {

	String status;
	String message;

	public Helper(){

	}
	
	public Helper(String status,
	String message) {
		this.message = message;
		this.status = status;
	}
	
	public Helper error(String responeString,String messageString) {
		
		Helper erroHelper = new Helper(responeString, messageString);
		return erroHelper;
	}
	
public Helper success(String responeString,String messageString) {
		
		Helper successHelper = new Helper(responeString, messageString);
		return successHelper;
	}

public String getResponseString() {
	return status;
}

public void setResponseString(String responeString) {
	this.status = responeString;
}

public String getMessageString() {
	return message;
}

public void setMessageString(String messageString) {
	this.message = messageString;
}
}
