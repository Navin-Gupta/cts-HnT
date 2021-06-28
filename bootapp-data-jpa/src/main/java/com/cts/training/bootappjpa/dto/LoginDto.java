package com.cts.training.bootappjpa.dto;

public class LoginDto {

	private String message;
	private Long loginTimeStamp;
	
	public LoginDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public LoginDto(String message, Long loginTimeStamp) {
		super();
		this.message = message;
		this.loginTimeStamp = loginTimeStamp;
	}



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getLoginTimeStamp() {
		return loginTimeStamp;
	}
	public void setLoginTimeStamp(Long loginTimeStamp) {
		this.loginTimeStamp = loginTimeStamp;
	}
	
	
}
