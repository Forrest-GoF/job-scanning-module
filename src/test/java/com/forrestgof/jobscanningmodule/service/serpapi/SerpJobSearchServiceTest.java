package com.forrestgof.jobscanningmodule.service.serpapi;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.dto.JobPreview;
import com.forrestgof.jobscanningmodule.dto.SearchFilter;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class SerpJobSearchServiceTest {

	@Autowired
	SerpJobSearchService serpJobSearchService;

	@Test
	public void preview_조회() throws Exception {
		//given
		SearchFilter searchFilter = new SearchFilter();

		//when
		List<JobPreview> jobPreviews = serpJobSearchService.searchPreview(searchFilter);

		//then
		System.out.println(jobPreviews.get(0).toString());
	}
}
