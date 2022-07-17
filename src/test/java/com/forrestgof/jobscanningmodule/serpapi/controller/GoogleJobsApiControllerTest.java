package com.forrestgof.jobscanningmodule.serpapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.forrestgof.jobscanningmodule.serpapi.SerpApiSearchException;
import com.google.gson.JsonObject;

class GoogleJobsApiControllerTest {

	@Test
	@DisplayName("쿼리 검색 크롤링 결과")
	void search() throws SerpApiSearchException {
		//given
		GoogleJobsApiController googleJobsApiController = GoogleJobsApiController.getInstance();

		//when
		JsonObject jobsResult = googleJobsApiController.search("개발자 채용");
		// JsonObject jobsResult = null;

		//log
		System.out.println(jobsResult);

		//then
		assertTrue(jobsResult != null);
	}

}
