package com.forrestgof.jobscanningmodule.serpapi.controller;

import java.util.HashMap;
import java.util.Map;

import com.forrestgof.jobscanningmodule.serpapi.config.SerpApiKey;
import com.google.gson.JsonObject;

public class SerpApiController {

	final String PARAMETER_NAME_API_KEY = "api_key";
	final String PARAMETER_NAME_ENGINE = "engine";
	final String PARAMETER_NAME_QUERY = "q";

	private final SerpApiKey serpApiKey;
	final Map<String, String> parameter;

	SerpApiController() {
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
