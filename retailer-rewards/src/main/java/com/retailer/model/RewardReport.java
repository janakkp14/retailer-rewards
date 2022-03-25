package com.retailer.model;

import java.util.HashMap;

import lombok.Data;

/**
 * 
 * @author Janak Patel
 */

@Data
public class RewardReport {
	
	private String customerId;

	private String customerName;

	private HashMap<String, Double> monthlyReward;

	private Double totalReward;

	@Override
	public String toString() {
		return "RewardReport [customerId=" + customerId + ", customerName=" + customerName + ", monthlyReward="
				+ monthlyReward + ", totalReward=" + totalReward + "]";
	}
}
