package com.retailer.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.retailer.model.RewardReport;
import com.retailer.model.Rewards;
import com.retailer.service.RewardsService;

@RunWith(MockitoJUnitRunner.class)
public class RewardsControllerTest {
	
	@InjectMocks
	RewardsController controller;
	
	@Mock
	private RewardsService rewardsService;
	
	@Test
	public void testGetRewardsForCustomer() {
		String customerId = "101";
		RewardReport report = new RewardReport();
		report.setCustomerId(customerId);
		Mockito.when(rewardsService.getRewardsByCustomerId(customerId)).thenReturn(report);
		controller.getRewardsForCustomer(customerId);
	}
	
	@Test
	public void testGetRewardsForAllCustomer() {
		String customerId = "101";
		List<RewardReport> reportList = new ArrayList<>();
		RewardReport report = new RewardReport();
		report.setCustomerId(customerId);
		reportList.add(report);
		Rewards rewards = new Rewards();
		rewards.setReportList(reportList);
		Mockito.when(rewardsService.getAllCustomerRewards()).thenReturn(rewards);
		controller.getRewardsForAllCustomer();
	}
}


