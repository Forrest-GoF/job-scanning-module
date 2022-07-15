package com.forrestgof.jobscanningmodule.serpapi.demo;

import java.util.HashMap;
import java.util.Map;

import com.forrestgof.jobscanningmodule.serpapi.GoogleSearch;
import com.forrestgof.jobscanningmodule.serpapi.config.SerpApiKey;
import com.google.gson.JsonObject;

public class GoogleJobsApiDemo {
	public static void main(String[] args) {

		SerpApiKey serpApiKey = SerpApiKey.getInstance();
		String API_KEY = serpApiKey.getKey();

		Map<String, String> parameter = new HashMap<>();

		parameter.put("engine", "google_jobs");
		parameter.put("q", "개발자 채용");
		// parameter.put("hl", "en");
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
