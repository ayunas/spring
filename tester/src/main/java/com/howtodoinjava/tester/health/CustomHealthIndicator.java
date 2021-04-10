package com.howtodoinjava.tester.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health getHealth(boolean includeDetails) {
		return null;
	}

	@Override
	public Health health() {
		boolean error = true;

		if (error) {
			return Health.down().withDetail("error key", 123).build();
		}

		return Health.up().build();
	}
}
