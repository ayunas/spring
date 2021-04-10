package com.howtodoinjava.tester.health;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		Map<String, Object> userDetails = new HashMap<>();
		userDetails.put("active", 20);
		userDetails.put("inactive", 5);
		userDetails.put("firstName", "Amir");
		userDetails.put("lastName", "Yunas");
		builder.withDetail("users", userDetails);
	}
}
