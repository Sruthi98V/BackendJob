package com.sayone.exceptions;

public enum ExceptionsEnum {

	JOBS_NOT_FOUND("jobs.not.found"),
	INVALID_STATUS("invalid.status");

	private final String type;
	
	private ExceptionsEnum(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return this.type;
	}
	
}
