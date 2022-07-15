package com.forrestgof.jobscanningmodule.serpapi.controller;

import com.forrestgof.jobscanningmodule.serpapi.GoogleSearch;
import com.google.gson.JsonObject;

public class GoogleJobsApiController extends SerpApiController {

	private final String PARAMETER_NAME_LOCATION = "location";
	private final String PARAMETER_NAME_GOOGLE_DOMAIN = "google_domain";
	private final String PARAMETER_NAME_LANGUAGE_CODE = "hl";
	private final String PARAMETER_NAME_COUNTRY_CODE = "gl";
	private final String LOCATION = "South Korea";
	private final String GOOGLE_DOMAIN = "google.co.kr";
	private final String LANGUAGE_CODE = "ko";
	private final String COUNTRY_CODE = "kr";
	private final String SEARCH_ENGINE = "google_jobs";

	private static GoogleJobsApiController instance;

	@Override
	void setRequiredParameter() {
		parameter.put(PARAMETER_NAME_ENGINE, SEARCH_ENGINE);
	}

	@Override
	void setOptionalParameter() {
		parameter.put(PARAMETER_NAME_LOCATION, LOCATION);
		parameter.put(PARAMETER_NAME_GOOGLE_DOMAIN, GOOGLE_DOMAIN);
		parameter.put(PARAMETER_NAME_LANGUAGE_CODE, LANGUAGE_CODE);
		parameter.put(PARAMETER_NAME_COUNTRY_CODE, COUNTRY_CODE);
	}

	public static GoogleJobsApiController getInstance() {
		if (instance == null) {
			instance = new GoogleJobsApiController();
		}
		return instance;
	}

	@Override
	public JsonObject search(String query) {
		parameter.put(PARAMETER_NAME_QUERY, query);

		GoogleSearch search = new GoogleSearch(parameter);

		JsonObject jobsResult = null;
		try {
			jobsResult = search.getJson();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobsResult;
	}
}
