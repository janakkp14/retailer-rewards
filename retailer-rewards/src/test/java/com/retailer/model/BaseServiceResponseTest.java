package com.retailer.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseServiceResponseTest {
	
	@InjectMocks
	private BaseServiceResponse response;
	
	@Test
	public void testSetStatusCode() {
		String statusCode = "101";
		response.setStatusCode(statusCode);
	}
	
	@Test
	public void testGetStatusCode() {
		response.getStatusCode();
	}
	
	@Test
	public void testSetErrorMessage() {
		String errorMessage = "error";
		response.setErrorMessage(errorMessage);
	}
	
	@Test
	public void testGetErrorMessage() {
		response.getErrorMessage();
	}
	
	@Test
	public void testSetDisplayMessage() {
		String displayMessage = "display";
		response.setDisplayMessage(displayMessage);
	}
	
	@Test
	public void testGetDisplayMessage() {
		response.getDisplayMessage();
	}
	
	@Test
	public void testSetDisplayMessageCode() {
		String displayMessageCode = "display";
		response.setDisplayMessageCode(displayMessageCode);
	}
	
	@Test
	public void testGetDisplayMessageCode() {
		response.getDisplayMessageCode();
	}

}
