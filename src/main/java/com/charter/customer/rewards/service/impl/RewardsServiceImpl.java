package com.charter.customer.rewards.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.customer.rewards.dto.Customer;
import com.charter.customer.rewards.dto.Transactions;
import com.charter.customer.rewards.repository.CustomerRewardRepository;
import com.charter.customer.rewards.service.RewardsService;

@Service
public class RewardsServiceImpl implements RewardsService {
	Logger logger = LoggerFactory.getLogger(RewardsServiceImpl.class);
	
	@Autowired
	CustomerRewardRepository customerRewardRepo;
	@Override
	public List<Customer> calculateRewardsForAll() {		
		logger.info("calculateRewardsForAll method In RewardServiceImpl start....");
		
		List<Customer> customerList = customerRewardRepo.findAll();
		if (customerList != null && !customerList.isEmpty()) {
			for (Customer customer : customerList) {
				logger.debug("Calculating rewards for Each Customer:::::"
						+ customer.getName());
				Set<Transactions> setOfTransaction = customer.getTransactions();
				setRewardsPerMonth(setOfTransaction, customer);
				logger.debug("End of reward calculation for customer" + customer.getName());
			}

		}
		
		logger.info("calculateRewardsForAll method in RewardServiceImpl ends....");
		return customerList;
	}

	@Override
	public Customer calculateRewardsbyId(Integer customerId) {
		logger.info("calculateRewardsbyId method In RewardServiceImpl start....");
		
		Customer customerReward = customerRewardRepo.findById(customerId).orElse(null);
		if(customerReward != null) {
			logger.debug("Calculating rewards for Each Customer:::::"
					+ customerReward.getName());
			Set<Transactions> setOfTransaction = customerReward.getTransactions();
			setRewardsPerMonth(setOfTransaction, customerReward);
			logger.debug("End of reward calculation for customer" + customerReward.getName());
		}
		
		logger.info("calculateRewardsbyId method In RewardServiceImpl end....");
		return customerReward;
	}
	
	private void setRewardsPerMonth(Set<Transactions> setOfTransaction, Customer customer) {
		LocalDate todayDate = LocalDate.now();
		
		for (Transactions transaction : setOfTransaction) {
			int transactionMon = transaction.getCreation_date().getMonth() + 1;
			int transactionYear = transaction.getCreation_date().getYear() + 1900;
			
			
			logger.debug("Start Calculating Rewards for Customer:::" + customer.getName() + " for Transaction Id::: "
					+ transaction.getId());

			if ((todayDate.getYear() == transactionYear) && (todayDate.getMonth().getValue() == transactionMon))
				customer.setThirdMonthRewards(customer.getThirdMonthRewards()
						+ calculateRewardAmountPerTrans(transaction.getTransaction_amount()));
			
			else if ((todayDate.minusMonths(1).getYear() == transactionYear)
					&& (todayDate.minusMonths(1).getMonth().getValue() == transactionMon))
				customer.setSecondMonthRewards(customer.getSecondMonthRewards()
						+ calculateRewardAmountPerTrans(transaction.getTransaction_amount()));
			else if ((todayDate.minusMonths(2).getYear() == transactionYear)
					&& (todayDate.minusMonths(2).getMonth().getValue() == transactionMon))
				customer.setFirstMonthRewards(customer.getFirstMonthRewards()
						+ calculateRewardAmountPerTrans(transaction.getTransaction_amount()));

			logger.debug("End Calculating Rewards for customer::::" + customer.getName() + " for Transaction Id:::"
					+ transaction.getId());

		}
	}
	
	private int calculateRewardAmountPerTrans(int transactionAmount) {
		logger.debug("Customer Transaction Amount:::" + transactionAmount);
		
		int rewardAmount = 0;
		if (transactionAmount > 50 && transactionAmount <= 100) {
			rewardAmount = transactionAmount - 50;
		} else if (transactionAmount > 100) {
			rewardAmount = (2 * (transactionAmount - 100) + 50);
		}
		
		logger.debug("Customer Reward Amount:::" + rewardAmount);
		return rewardAmount;
	}

}
