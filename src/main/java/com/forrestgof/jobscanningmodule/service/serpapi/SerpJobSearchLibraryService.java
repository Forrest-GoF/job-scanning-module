package com.forrestgof.jobscanningmodule.service.serpapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.forrestgof.jobscanningmodule.service.serpapi.config.SerpApiKey;
import com.forrestgof.jobscanningmodule.service.serpapi.library.GoogleSearch;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerpJobSearchLibraryService implements JobSearchLibraryService {

	private final SerpApiKey serpApiKey = SerpApiKey.getInstance();

	public JsonObject search(SearchFilter searchFilter) {
		Map<String, String> parameter = new HashMap<>();

		parameter.put("api_key", serpApiKey.getKey());
		parameter.put("engine", "google_jobs");
		parameter.put("q", searchFilter.getQ());

		parameter.put("location", searchFilter.getLocation());
		// parameter.put("uule", searchFilter.getUule());
		parameter.put("google_domain", searchFilter.getGoogleDomain());
		parameter.put("gl", searchFilter.getGl());
		parameter.put("hl", searchFilter.getHl());
		parameter.put("start", searchFilter.getStart());
		parameter.put("chips", searchFilter.getChips());
		parameter.put("irad", searchFilter.getIrad());

		GoogleSearch googleSearch = new GoogleSearch(parameter);
		JsonObject jobSearchResult = null;
		try {
			jobSearchResult = googleSearch.getJson();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return jobSearchResult;
	}
}
