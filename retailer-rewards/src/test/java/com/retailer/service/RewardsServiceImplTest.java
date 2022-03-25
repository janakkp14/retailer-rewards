package com.retailer.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.retailer.entities.Transaction;
import com.retailer.exception.RetailerRewardsException;
import com.retailer.model.RewardReport;
import com.retailer.repository.RewardsRepository;
import com.retailer.util.RewardCalculatorUtil;

@RunWith(MockitoJUnitRunner.class)
public class RewardsServiceImplTest {
	
	@InjectMocks
	private RewardsServiceImpl rewardsServiceImpl;
	
	@Mock
	private RewardsRepository rewardRepo;
	
	@Mock
	private RewardCalculatorUtil rewardCalculatorUtil;
	
	@Test
	public void testGetRewardsByCustomerId() {
		String customerId = "101";
		List<Transaction> transactionList = new ArrayList<>();
		Transaction transaction =  new Transaction();
    	transaction.setTransactionId("101");
		transactionList.add(transaction);
		RewardReport report = new RewardReport();
		report.setCustomerId(customerId);
		Mockito.when(rewardRepo.findByCustomerId(customerId)).thenReturn(transactionList);
		Mockito.when(rewardCalculatorUtil.generateTransactionReport(transactionList)).thenReturn(report);
		rewardsServiceImpl.getRewardsByCustomerId(customerId);
	}
	
	@Test(expected = RetailerRewardsException.class)
	public void testGetRewardsByCustomerIdForElse() {
		String customerId = "101";
		List<Transaction> transactionList = new ArrayList<>();
		Mockito.when(rewardRepo.findByCustomerId(customerId)).thenReturn(transactionList);
		rewardsServiceImpl.getRewardsByCustomerId(customerId);
	}
	
	@Test
	public void testGetAllCustomerRewards() {
		String customerId = "101";
		List<String> customerList = new ArrayList<>();
		customerList.add("101");
		
		RewardReport report = new RewardReport();
		report.setCustomerId(customerId);
		Mockito.when(rewardRepo.findAllCustomers()).thenReturn(customerList);
		
		List<Transaction> transactionList = new ArrayList<>();
		Transaction transaction =  new Transaction();
		transaction.setTransactionId("101");
		transactionList.add(transaction);
		Mockito.when(rewardRepo.findByCustomerId(customerId)).thenReturn(transactionList);
		Mockito.when(rewardCalculatorUtil.generateTransactionReport(transactionList)).thenReturn(report);
		rewardsServiceImpl.getAllCustomerRewards();
	}
	
	@Test(expected = RetailerRewardsException.class)
	public void testGetAllCustomerRewardsForException() {
		rewardsServiceImpl.getAllCustomerRewards();
	}
}
