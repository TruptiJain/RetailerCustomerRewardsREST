package com.charter.customer.rewards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.charter.customer.rewards.dto.Customer;
import com.charter.customer.rewards.service.RewardsService;

@SpringBootTest
class RetailerCustomerRewardsRestApplicationTests {
	
	@Autowired
	RewardsService rewardsService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCalculateRewardsforMultipleTransactions() {
		Customer customer=rewardsService.calculateRewardsbyId(1);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==1) {
			Assertions.assertEquals(300,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforAmountBelowFifty() {
		Customer customer=rewardsService.calculateRewardsbyId(5);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==5) {
			Assertions.assertEquals(0,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforAmountAboveFiftyBelowHundred() {
		Customer customer=rewardsService.calculateRewardsbyId(3);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==3) {
			Assertions.assertEquals(5,customer.getTotalRewardAmount());
		}		
	}

	@Test
	void testCalculateRewardsforAmountAboveHundred() {
		Customer customer=rewardsService.calculateRewardsbyId(4);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==4) {
			Assertions.assertEquals(60,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforPastDate() {
		Customer customer=rewardsService.calculateRewardsbyId(6);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==6) {
			Assertions.assertEquals(0,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforHundred() {
		Customer customer=rewardsService.calculateRewardsbyId(7);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==7) {
			Assertions.assertEquals(50,customer.getTotalRewardAmount());
		}		
	}

}
