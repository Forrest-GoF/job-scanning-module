package com.forrestgof.jobscanningmodule.serpapi.demo;

import java.util.HashMap;
import java.util.Map;

import com.forrestgof.jobscanningmodule.serpapi.GoogleSearch;
import com.forrestgof.jobscanningmodule.serpapi.config.JobId;
import com.forrestgof.jobscanningmodule.serpapi.config.SerpApiKey;
import com.google.gson.JsonObject;

public class GoogleJobLinkApiDemo {
	public static void main(String[] args) {

		SerpApiKey serpApiKey = SerpApiKey.getInstance();
		final String API_KEY = serpApiKey.getKey();

		JobId jobId = new JobId();
		String JOB_ID = jobId.get();

		Map<String, String> parameter = new HashMap<>();

		parameter.put("engine", "google_jobs_listing");
		parameter.put("q", JOB_ID);
		parameter.put("api_key", API_KEY);

		GoogleSearch search = new GoogleSearch(parameter);

		try {
			JsonObject results = search.getJson();
			String jobs_results = results.toString();
			System.out.println(jobs_results);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
