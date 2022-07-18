package com.forrestgof.jobscanningmodule.service.serpapi.config;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class SerpApiKey {
	// 이거 주입하는 것부터 고쳐야함...
	// @Value("${serp-api-key}")
	// private String key;
	private String key = "bae4a88cab2f86026d6b1de0bcb3c0e2a5069e5f464d6e76ec88f6a1028bfe07";

	private static SerpApiKey instance;

	private SerpApiKey() {
	}

	public static SerpApiKey getInstance() {
		if (instance == null) {
			instance = new SerpApiKey();
		}
		return instance;
	}
}
