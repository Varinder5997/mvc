package com.mindtree.restoline.dto;

/*
 * Dto class for Login
 */
public class LoginDto {
	
	private String guestEmail;//Guest email of string type
	private String guestPassword;//Guest password
	/*
	 * Super Constructor
	 */
	public LoginDto() {
		super();
	
	}
	/*
	 * Geters and seters
	 */
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestPassword() {
		return guestPassword;
	}
	public void setGuestPassword(String guestPassword) {
		this.guestPassword = guestPassword;
	}
	

}
