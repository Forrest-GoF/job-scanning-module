package com.forrestgof.jobscanningmodule.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.forrestgof.jobscanningmodule.domain.Company;
import com.forrestgof.jobscanningmodule.domain.JobPosting;
import com.forrestgof.jobscanningmodule.domain.JobType;
import com.forrestgof.jobscanningmodule.domain.Location;
import com.forrestgof.jobscanningmodule.dto.CompanyDto;
import com.forrestgof.jobscanningmodule.dto.JobDetail;
import com.forrestgof.jobscanningmodule.dto.JobPreview;
import com.forrestgof.jobscanningmodule.dto.LocationDto;
import com.forrestgof.jobscanningmodule.dto.SearchFilter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {

	private final JobPostingService jobPostingService;
	private final JobSearchService jobSearchService;

	public List<JobPreview> previews(SearchFilter searchFilter) {
		List<JobPreview> jobPreviews = jobSearchService.searchPreview(searchFilter);
		fill(jobPreviews);
		return jobPreviews;
	}

	public JobDetail detail(String key) {
		if (jobPostingService.existsByKey(key)) {
			JobPosting byKey = jobPostingService.findByKey(key);
			return toJobDetail(byKey);
		} else {
			JobDetail jobDetail = jobSearchService.searchDetail(key);
			JobPosting jobPosting = toJobPosting(jobDetail);
			jobPostingService.save(jobPosting);
			return jobDetail;
		}
	}

	public void fill(List<JobPreview> jobPreviews) {
		jobPreviews.stream()
			.map(JobPreview::getKey)
			.filter(Predicate.not(jobPostingService::existsByKey))
			.map(jobSearchService::searchDetail)
			.map(this::toJobPosting)
			.forEach(jobPostingService::save);
	}

	JobPosting toJobPosting(JobDetail jobDetail) {
		Company company = Company.of(jobDetail.getCompany().getName(), jobDetail.getCompany().getThumbnail());
		Location location = Location.from(jobDetail.getLocation().getName());
		return JobPosting.builder()
			.key(jobDetail.getKey())
			.title(jobDetail.getTitle())
			.company(company)
			.location(location)
			.platform(jobDetail.getPlatform())
			.postedAt(jobDetail.getPostedAt())
			.jobType(JobType.valueOf(jobDetail.getType()))
			.salary(jobDetail.getSalary())
			.applyingUrl(jobDetail.getApplyUrl())
			.description(jobDetail.getDescription())
			.build();
	}

	JobDetail toJobDetail(JobPosting jobPosting) {
		JobDetail jobDetail = new JobDetail();
		jobDetail.setKey(jobPosting.getKey());
		jobDetail.setTitle(jobPosting.getTitle());
		jobDetail.setCompany(new CompanyDto(jobPosting.getCompany().getName(), jobPosting.getCompany().getThumbnail()));
		jobDetail.setLocation(new LocationDto(jobPosting.getLocation().getName()));
		jobDetail.setPlatform(jobPosting.getPlatform());
		jobDetail.setPostedAt(jobPosting.getPostedAt());
		jobDetail.setType(jobPosting.getJobType().toString());
		jobDetail.setSalary(jobPosting.getSalary());
		jobDetail.setApplyUrl(jobPosting.getApplyingUrl());
		jobDetail.setDescription(jobPosting.getDescription());
		return jobDetail;
	}
}
