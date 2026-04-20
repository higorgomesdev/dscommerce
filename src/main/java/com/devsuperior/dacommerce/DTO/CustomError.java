package com.devsuperior.dacommerce.DTO;

import java.time.Instant;

public class CustomError {
	
	private Instant timestamp;
	private Integer Status;
	private String Error;
	private String path;
	
	public CustomError(Instant timestamp, Integer status, String error, String path) {
		this.timestamp = timestamp;
		Status = status;
		Error = error;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public Integer getStatus() {
		return Status;
	}

	public String getError() {
		return Error;
	}

	public String getPath() {
		return path;
	}
	
	
	
}
