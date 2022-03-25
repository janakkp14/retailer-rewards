package com.retailer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailer.entities.Transaction;
import com.retailer.exception.RetailerRewardsException;
import com.retailer.model.RewardReport;
import com.retailer.model.Rewards;
import com.retailer.repository.RewardsRepository;
import com.retailer.util.RewardCalculatorUtil;

/**
 * 
 * @author Janak Patel
 */
@Service("rewardService")
@Transactional
public class RewardsServiceImpl implements RewardsService {
	private static final Logger logger = LogManager.getLogger(RewardsServiceImpl.class);

	@Autowired
	private RewardsRepository rewardRepo;

	@Autowired
	private RewardCalculatorUtil rewardCalculatorUtil;

	@Override
	public RewardReport getRewardsByCustomerId(String id) {
		logger.info("Inside RewardsServiceImpl : getRewardsByCustomerId() with customer Id:{} ", id);
		RewardReport transactionReport = null;
		List<Transaction> transactions = rewardRepo.findByCustomerId(id);
		if (transactions.size() > 0) {
			logger.info("Inside RewardsServiceImpl : Fetched customer with customer Id:{}", id);
			transactionReport = rewardCalculatorUtil.generateTransactionReport(transactions);
		} else {
			logger.info("Inside RewardsServiceImpl : No customer found with customer Id: {}", id);
			throw new RetailerRewardsException("ERROR_1", "No customer found with customer Id" + id);
		}
		return transactionReport;
	}

	@Override
	public Rewards getAllCustomerRewards() {
		logger.info("Inside RewardsServiceImpl : getRewardsByCustomerId()");
		Rewards rewards = null;
		List<String> customerList = rewardRepo.findAllCustomers();
		logger.info("Inside RewardsServiceImpl : Fetched customer with customerList:{}", customerList);
		if (customerList.size() > 0) {
			rewards = new Rewards();
			List<RewardReport> reportList = new ArrayList<RewardReport>();
			for (String customerId : customerList) {
				RewardReport report = getRewardsByCustomerId(customerId);
				reportList.add(report);
			}
			rewards.setReportList(reportList);
		} else {
			logger.info("Inside RewardsServiceImpl : No customer found");
			throw new RetailerRewardsException("ERROR_1", "No customer found");
		}
		return rewards;
	}
}
