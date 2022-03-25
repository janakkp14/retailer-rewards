package com.retailer.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.retailer.model.BaseServiceResponse;
import com.retailer.service.RewardsServiceImpl;

public class RetailerRewardsExceptionHandler extends ResponseEntityExceptionHandler {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(RewardsServiceImpl.class);

	private static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";

	public final ResponseEntity<BaseServiceResponse> handleRetailerRewardsException(RetailerRewardsException ex,
			ServletWebRequest request) {
		String code = ex.getErrorCode();
		String exceptionMessage = ex.getMessage();
		BaseServiceResponse response = new BaseServiceResponse();
		response.setStatusCode(INTERNAL_SERVER_ERROR);
		response.setErrorMessage(exceptionMessage);
		response.setDisplayMessage(code);
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<BaseServiceResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}