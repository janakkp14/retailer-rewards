package com.retailer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.model.RewardReport;
import com.retailer.model.Rewards;
import com.retailer.service.RewardsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Janak Patel
 * 
 */

@RestController
@RequestMapping("/retailer")
@Api(value = "API List")
public class RewardsController {
	private static final Logger logger = LogManager.getLogger(RewardsController.class);

	@Autowired
	private RewardsService rewardsService;

	@GetMapping(produces = { "application/json" }, value = "/reward/{id}")
	@ApiOperation(value = "API to fetch rewards for particular customer", notes = "Fetch reqrds for particular customer", response = RewardReport.class)
	public ResponseEntity<RewardReport> getRewardsForCustomer(@PathVariable("id") String id) {
		logger.info("Inside RewardsController : getRewardsForCustomer() with customer Id: " + id);
		RewardReport report = rewardsService.getRewardsByCustomerId(id);
		return new ResponseEntity<RewardReport>(report, HttpStatus.OK);
	}

	@GetMapping(produces = { "application/json" }, value = "/rewards")
	@ApiOperation(value = "API to fetch rewards for all customer", notes = "Fetch reqrds for all customer", response = Rewards.class)
	public ResponseEntity<Rewards> getRewardsForAllCustomer() {
		logger.info("Inside RewardsController : getRewardsForAllCustomer()");
		Rewards rewards = rewardsService.getAllCustomerRewards();
		return new ResponseEntity<Rewards>(rewards, HttpStatus.OK);
	}
}
