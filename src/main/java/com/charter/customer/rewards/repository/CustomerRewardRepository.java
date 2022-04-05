package com.charter.customer.rewards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.charter.customer.rewards.dto.Customer;

@Repository
public interface CustomerRewardRepository extends JpaRepository<Customer, Integer>{

}
