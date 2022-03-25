package com.retailer.service;

import com.retailer.model.RewardReport;
import com.retailer.model.Rewards;

public interface RewardsService {
	
	RewardReport getRewardsByCustomerId(String id);
	
	Rewards getAllCustomerRewards();
}
