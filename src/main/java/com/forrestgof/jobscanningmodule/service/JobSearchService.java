package com.forrestgof.jobscanningmodule.service;

import java.util.List;

import com.forrestgof.jobscanningmodule.dto.JobDetail;
import com.forrestgof.jobscanningmodule.dto.JobPreview;
import com.forrestgof.jobscanningmodule.dto.SearchFilter;

public abstract class JobSearchService {

	public abstract List<JobPreview> searchPreview(SearchFilter searchFilter);

	public abstract JobDetail searchDetail(String key);
}

