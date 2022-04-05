package com.charter.customer.rewards.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	Logger logger = LoggerFactory.getLogger(HealthCheckController.class);
	
	@GetMapping("/hello")
	public String hello() {
		logger.debug("TestController...hello world ...");
		return "Success";
	}

	@GetMapping("/health")
	public String health() {
		logger.debug("Health GET API call test ...");
		return "You reached the Health GET API endpoint successfully!! Test finished.";
	}

}
