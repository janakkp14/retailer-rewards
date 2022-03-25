package com.retailer.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.retailer.entities.Transaction;
import com.retailer.service.RewardsService;

@RunWith(MockitoJUnitRunner.class)
public class RewardCalculatorUtilTest {
	
	@InjectMocks
	private RewardCalculatorUtil rewardCalculatorUtil;
	
	@Mock
	private RewardsService rewardsService;
	
	@Test
	public void testGenerateTransactionReport() {
		List<Transaction> transactionList = new ArrayList<>();
		Transaction transaction =  new Transaction();
		transaction.setTransactionId("101");
		transaction.setTransactionDate(new Date(0));
		transaction.setTransactionAmount(new BigDecimal(175.50));
		transactionList.add(transaction);
		rewardCalculatorUtil.generateTransactionReport(transactionList);
	}
	
	@Test
	public void testCalculateReward() {
		List<Transaction> transactionList = new ArrayList<>();
		Transaction transaction =  new Transaction();
		transaction.setTransactionId("101");
		transaction.setTransactionDate(new Date(0));
		transaction.setTransactionAmount(new BigDecimal(175.50));
		
		Transaction transaction1 =  new Transaction();
		transaction1.setTransactionId("101");
		transaction1.setTransactionDate(new Date(0));
		transaction1.setTransactionAmount(new BigDecimal(65.70));
		transactionList.add(transaction);
		transactionList.add(transaction1);
		rewardCalculatorUtil.generateTransactionReport(transactionList);
	}
	
}
