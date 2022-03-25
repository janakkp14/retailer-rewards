package com.retailer.model;

import lombok.Data;

@Data
public class BaseServiceResponse {
	private String statusCode;

	private String errorMessage;

	private String displayMessage;

	private String displayMessageCode;

	@Override
	public String toString() {
		return "BaseServiceResponse [statusCode=" + statusCode + ", errorMessage=" + errorMessage + ", displayMessage="
				+ displayMessage + ", displayMessageCode=" + displayMessageCode + "]";
	}
}
