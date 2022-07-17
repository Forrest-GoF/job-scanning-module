package com.forrestgof.jobscanningmodule.serpapi.service;

import com.forrestgof.jobscanningmodule.serpapi.GoogleSearch;
import com.google.gson.JsonObject;

public class GoogleJobLinkApiService extends SerpApiService {

	private final String SEARCH_ENGINE = "google_jobs_listing";

	private static GoogleJobLinkApiService instance;

	@Override
	void setRequiredParameter() {
		parameter.put(PARAMETER_NAME_ENGINE, SEARCH_ENGINE);
	}

	public static GoogleJobLinkApiService getInstance() {
		if (instance == null) {
			instance = new GoogleJobLinkApiService();
		}
		return instance;
	}

	@Override
	public JsonObject search(String jobId) {
		parameter.put(PARAMETER_NAME_QUERY, jobId);

		GoogleSearch search = new GoogleSearch(parameter);

		JsonObject jobLinkResult = null;
		try {
			jobLinkResult = search.getJson();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobLinkResult;
	}
}
