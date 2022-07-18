package com.forrestgof.jobscanningmodule.service.serpapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.forrestgof.jobscanningmodule.service.serpapi.library.SerpApiSearchException;
import com.google.gson.JsonObject;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SerpJobSearchLibraryServiceTest {

	@Autowired
	SerpJobSearchLibraryService serpJobSearchLibraryService;

	@Test
	@DisplayName("구글 잡스 검색 크롤링 결과")
	void search() throws SerpApiSearchException {
		//given
		SearchFilter searchFilter = new SearchFilter();
		searchFilter.setQ("개발자 채용");
		searchFilter.setLocation("");
		searchFilter.setUule("");
		searchFilter.setGoogleDomain("");
		searchFilter.setGl("");
		searchFilter.setHl("");
		searchFilter.setStart("");
		searchFilter.setChips("");
		searchFilter.setIrad("");

		//when
		JsonObject jobSearchResult = serpJobSearchLibraryService.search(searchFilter);

		//log
		System.out.println(jobSearchResult);

		//then
		Assertions.assertTrue(jobSearchResult != null);
	}
}
