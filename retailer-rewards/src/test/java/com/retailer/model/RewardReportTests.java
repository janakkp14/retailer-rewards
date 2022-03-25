package com.retailer.model;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RewardReportTests {
	
	@InjectMocks
	private RewardReport report;
	
	@Test
	public void testSetCustomerId() {
		String customerId = "101";
		report.setCustomerId(customerId);
	}
	
	@Test
	public void testGetCustomerId() {
		report.getCustomerId();
	}
	
	@Test
	public void testSetCustomerName() {
		String customerName = "Janak";
		report.setCustomerName(customerName);
	}
	@Test
	public void testGetCustomerName() {
		report.getCustomerName();
	}
	
	@Test
	public void testSetMonthlyReward() {
		HashMap<String, Double> rewardMap = new HashMap<>();
		rewardMap.put("reward", 123.56);
		report.setMonthlyReward(rewardMap);
	}
	
	@Test
	public void testGetMonthlyReward() {
		report.getMonthlyReward();
	}
	
	@Test
	public void testSetTotalReward() {
		double totalReward = 123.5;
		report.setTotalReward(totalReward);
	}
	@Test
	public void testTotalReward() {
		report.getTotalReward();
	}
}
