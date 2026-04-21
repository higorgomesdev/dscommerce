package com.devsuperior.dacommerce.DTO;

public class FieldMessage {
	
	private String feildName;
	private String message;
	
	public FieldMessage(String feildName, String message) {
		this.feildName = feildName;
		this.message = message;
	}

	public String getFeildName() {
		return feildName;
	}

	public String getMessage() {
		return message;
	}
	
	

}
