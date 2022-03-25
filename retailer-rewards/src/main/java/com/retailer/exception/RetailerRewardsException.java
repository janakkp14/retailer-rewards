package com.retailer.exception;

import lombok.Getter;
import lombok.Setter;

public class RetailerRewardsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Setter
	@Getter
	private String errorCode;

	public RetailerRewardsException() {
		super();
	}

	public RetailerRewardsException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}
}