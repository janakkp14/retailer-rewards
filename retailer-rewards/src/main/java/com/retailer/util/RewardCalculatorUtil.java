package com.retailer.util;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retailer.entities.Transaction;
import com.retailer.model.RewardReport;

/**
 * 
 * @author Janak Patel
 */

@Service
@Transactional
public class RewardCalculatorUtil {
	private static final Logger logger = LogManager.getLogger(RewardCalculatorUtil.class);

	public RewardReport generateTransactionReport(List<Transaction> transactionList) {
		logger.info("Inside RewardCalculatorUtil : inside generateTransactionReport() with transactionList: {}",
				transactionList);
		return calculateReward(transactionList);
	}

	/**
	 * @param transactionList
	 * @return
	 */
	private RewardReport calculateReward(List<Transaction> transactionList) {
		RewardReport report = new RewardReport();
		logger.info("Inside RewardCalculatorUtil : calculateReward() with transactionList: {}", transactionList);
		HashMap<String, Double> monthlyReward = new HashMap<String, Double>();
		report.setCustomerId(transactionList.get(0).getCustomerId());
		report.setCustomerName(transactionList.get(0).getCustomerName());
		for (Transaction transaction : transactionList) {
			Date transactionDate = transaction.getTransactionDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(transactionDate);
			Integer month = calendar.get(Calendar.MONTH);
			String monthInWords = getMonthForInt(month);
			if (monthlyReward.containsKey(monthInWords)) {
				double rewardPointPerMonth = getRewardPointByMonth(transaction);
				double existingPoint = monthlyReward.get(monthInWords);
				Double sum = rewardPointPerMonth + existingPoint;
				monthlyReward.put(monthInWords, sum);
			} else {
				double rewardPointPerMonth = getRewardPointByMonth(transaction);
				monthlyReward.put(monthInWords, rewardPointPerMonth);
			}
		}
		report.setMonthlyReward(monthlyReward);
		report.setTotalReward(calculateTotalPoints(monthlyReward));
		logger.info("Exiting RewardCalculatorUtil: calculateReward: report: " + report);
		return report;
	}

	/**
	 * @param transaction
	 * @return
	 */
	private double getRewardPointByMonth(Transaction transaction) {
		logger.info("Inside RewardCalculatorUtil : getRewardPointByMonth() with transaction: {}", transaction);
		double currentReward = 0;
		double tranAmount = transaction.getTransactionAmount().doubleValue();
		if (tranAmount > 50 && tranAmount <= 100) {
			currentReward = currentReward + 1 * (tranAmount - 50);
		}
		if (tranAmount > 100) {
			currentReward = currentReward + 2 * (tranAmount - 100) + 50;
		}
		logger.info("Exiting RewardCalculatorUtil: getRewardPointByMonth: currentReward: " + currentReward);
		return currentReward;
	}

	/**
	 * @param monthlyReward
	 * @return
	 */
	private double calculateTotalPoints(HashMap<String, Double> monthlyReward) {
		logger.info("Inside RewardCalculatorUtil : totalPoints() with monthlyReward: {}", monthlyReward);
		double totalPoints = 0;
		for (double points : monthlyReward.values()) {
			totalPoints += points;
		}
		logger.info("Exiting RewardCalculatorUtil: totalPoints: totalPoints: " + totalPoints);
		return totalPoints;
	}

	/**
	 * @param num
	 * @return
	 */
	private String getMonthForInt(int num) {
		String month = "";
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
		String[] months = dateFormatSymbols.getMonths();
		if (num >= 0 && num <= 11) {
			month = months[num];
		}
		return month;
	}
}
