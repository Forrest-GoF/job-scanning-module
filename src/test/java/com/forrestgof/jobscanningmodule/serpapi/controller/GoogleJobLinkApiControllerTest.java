package com.forrestgof.jobscanningmodule.serpapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.forrestgof.jobscanningmodule.serpapi.SerpApiSearchException;
import com.google.gson.JsonObject;

class GoogleJobLinkApiControllerTest {

	final String JOB_ID = "eyJqb2JfdGl0bGUiOiJCYWNrLWVuZCDqsJzrsJzsnpAiLCJodGlkb2NpZCI6Ilg4OFBsNUVGMHI4QUFBQUFBQUFBQUE9PSIsInV1bGUiOiJ3K0NBSVFJQ0lMVTI5MWRHZ2dTMjl5WldFIiwiZ2wiOiJrciIsImhsIjoia28iLCJhcHBseV9saW5rIjp7InRpdGxlIjoi7KeA7JuQ7ZWY6riwOiDsm5Dti7Drk5wiLCJsaW5rIjoiaHR0cHM6Ly93d3cud2FudGVkLmNvLmtyL3dkLzEyMDc1Mj91dG1fY2FtcGFpZ249Z29vZ2xlX2pvYnNfYXBwbHlcdTAwMjZ1dG1fc291cmNlPWdvb2dsZV9qb2JzX2FwcGx5XHUwMDI2dXRtX21lZGl1bT1vcmdhbmljIn19";

	@Test
	@DisplayName("특정 공고 검색 크롤링 결과")
	void search() throws SerpApiSearchException {
		//given
		GoogleJobLinkApiController googleJobLinkApiController = GoogleJobLinkApiController.getInstance();

		//when
		JsonObject jobLinkResult = googleJobLinkApiController.search(JOB_ID);
		// JsonObject jobLinkResult = null;

		//log
		System.out.println(jobLinkResult);

		//then
		assertTrue(jobLinkResult != null);
	}
}
