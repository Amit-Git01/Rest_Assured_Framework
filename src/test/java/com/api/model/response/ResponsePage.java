package com.api.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponsePage {
	
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int userStatus;
	

	
}
