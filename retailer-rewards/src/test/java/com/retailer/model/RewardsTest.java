package com.retailer.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RewardsTest {

	@InjectMocks
	private Rewards rewards;

	@Test
	public void testSeReportList() {
		List<RewardReport> reportList = new ArrayList<>();
		RewardReport report = new RewardReport();
		report.setCustomerId("101");
		reportList.add(report);
		rewards.setReportList(reportList);
	}

	@Test
	public void testGetReportList() {
		rewards.getReportList();
	}
}
