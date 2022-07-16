package com.forrestgof.jobscanningmodule.service.serpapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.forrestgof.jobscanningmodule.dto.JobDetail;
import com.forrestgof.jobscanningmodule.dto.JobPreview;
import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.forrestgof.jobscanningmodule.service.JobSearchService;

@Service
public class SerpJobSearchService extends JobSearchService {
	//TODO
	@Override
	public List<JobPreview> searchPreview(SearchFilter searchFilter) {
		List<JobPreview> jobPreviews = new ArrayList<>();
		jobPreviews.add(new JobPreview());
		jobPreviews.add(new JobPreview());
		jobPreviews.add(new JobPreview());
		jobPreviews.add(new JobPreview());
		return jobPreviews;
	}

	//TODO
	@Override
	public JobDetail searchDetail(String key) {
		return new JobDetail();
	}
}
