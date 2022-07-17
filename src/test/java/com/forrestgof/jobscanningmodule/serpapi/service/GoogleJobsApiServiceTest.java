package com.forrestgof.jobscanningmodule.serpapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.forrestgof.jobscanningmodule.serpapi.SerpApiSearchException;
import com.google.gson.JsonObject;

class GoogleJobsApiServiceTest {

	GoogleJobsApiService googleJobsApiService = GoogleJobsApiService.getInstance();

	@Test
	@DisplayName("쿼리 검색 크롤링 결과")
	void search() throws SerpApiSearchException {
		//given
		String QUERY = "개발자 채용";

		//when
		JsonObject jobsResult = googleJobsApiService.search(QUERY);

		//log
		System.out.println(jobsResult.get("jobs_results"));

		//then
		Assertions.assertTrue(jobsResult != null);
	}
}
