package com.retailer.model;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author Janak Patel
 */

@Data
public class Rewards {

	private List<RewardReport> reportList;

	@Override
	public String toString() {
		return "RewardReport [reportList=" + reportList + "]";
	}
}
