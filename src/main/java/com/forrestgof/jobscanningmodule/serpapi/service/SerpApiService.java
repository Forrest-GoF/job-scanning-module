package com.forrestgof.jobscanningmodule.serpapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.forrestgof.jobscanningmodule.serpapi.config.SerpApiKey;
import com.google.gson.JsonObject;

@Service
public class SerpApiService {

	final String PARAMETER_NAME_API_KEY = "api_key";
	final String PARAMETER_NAME_ENGINE = "engine";
	final String PARAMETER_NAME_QUERY = "q";

	private final SerpApiKey serpApiKey;
	final Map<String, String> parameter;

	SerpApiService() {
		serpApiKey = SerpApiKey.getInstance();
		parameter = new HashMap<>();
		parameter.put(PARAMETER_NAME_API_KEY, serpApiKey.getKey());
		setDefaultParameter();
	}

	void setDefaultParameter() {
		setRequiredParameter();
		setOptionalParameter();
	}

	void setRequiredParameter() {
	}

	void setOptionalParameter() {
	}

	JsonObject search(String query) {
		return new JsonObject();
	}
}
