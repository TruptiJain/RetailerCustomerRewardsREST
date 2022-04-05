package com.charter.customer.rewards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.customer.rewards.dto.Customer;
import com.charter.customer.rewards.exception.CustomerNotFoundException;
import com.charter.customer.rewards.service.RewardsService;

@RestController
@RequestMapping("/charter")
public class RewardsController {
	Logger logger = LoggerFactory.getLogger(RewardsController.class);
	
	@Autowired
	public RewardsService rewardsService;
	
	@GetMapping(value="/customer/rewards", produces = "application/json")
    public ResponseEntity<Object> getAllCustomerRewards() {
		logger.info("getAllCustomerRewards method start.....");
		List<Customer> customerList = rewardsService.calculateRewardsForAll();
		
		if (customerList.isEmpty() || customerList.size() == 0) {
			logger.error("Customer List is empty");
			throw new CustomerNotFoundException("No Customers Present");
		}
		
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@GetMapping(value="/customer/rewards/{id}", produces = "application/json")
    public ResponseEntity<Customer> getCustomerRewardsById(@PathVariable Integer id) {
		logger.info("getAllCustomerRewards method start.....");
		Customer customerRewardsSummary = rewardsService.calculateRewardsbyId(id);
		
		if (customerRewardsSummary == null) {
			logger.error("Customer Object is Empty or No Customer Record Found");
			throw new CustomerNotFoundException("Customer with Id::::" + id + " does not exist");
		}
		
		return new ResponseEntity<Customer>(customerRewardsSummary, HttpStatus.OK);
	}
	
}
