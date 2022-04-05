package com.charter.customer.rewards.service;

import java.util.List;
import com.charter.customer.rewards.dto.Customer;

public interface RewardsService {
	
	List<Customer> calculateRewardsForAll();

	Customer calculateRewardsbyId(Integer id);
	
	
}
