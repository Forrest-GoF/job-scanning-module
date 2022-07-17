package com.forrestgof.jobscanningmodule.serpapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.forrestgof.jobscanningmodule.serpapi.SerpApiSearchException;
import com.forrestgof.jobscanningmodule.serpapi.config.JobId;
import com.google.gson.JsonObject;

class GoogleJobLinkApiServiceTest {

	GoogleJobLinkApiService googleJobLinkApiService = GoogleJobLinkApiService.getInstance();

	@Test
	@DisplayName("특정 공고 검색 크롤링 결과")
	void search() throws SerpApiSearchException {
		//given
		JobId jobId = new JobId();
		final String JOB_ID = jobId.get();

		//when
		JsonObject jobLinkResult = googleJobLinkApiService.search(JOB_ID);

		//log
		System.out.println(jobLinkResult);

		//then
		Assertions.assertTrue(jobLinkResult != null);
	}
}
