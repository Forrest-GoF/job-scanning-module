package com.forrestgof.jobscanningmodule.serpapi.controller;

import com.forrestgof.jobscanningmodule.serpapi.GoogleSearch;
import com.google.gson.JsonObject;

public class GoogleJobLinkApiController extends SerpApiController {

	private final String SEARCH_ENGINE = "google_jobs_listing";

	private static GoogleJobLinkApiController instance;

	@Override
	void setRequiredParameter() {
		parameter.put(PARAMETER_NAME_ENGINE, SEARCH_ENGINE);
	}

	public static GoogleJobLinkApiController getInstance() {
		if (instance == null) {
			instance = new GoogleJobLinkApiController();
		}
		return instance;
	}

	@Override
	public JsonObject search(String jobId) {
		parameter.put(PARAMETER_NAME_QUERY, jobId);

		GoogleSearch search = new GoogleSearch(parameter);

		JsonObject jobLinkResult = new JsonObject();
		try {
			jobLinkResult = search.getJson();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobLinkResult;
	}
}
