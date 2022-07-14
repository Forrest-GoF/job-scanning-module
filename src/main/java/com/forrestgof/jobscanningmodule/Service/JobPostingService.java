package com.forrestgof.jobscanningmodule.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.Repository.JobPostingRepository;
import com.forrestgof.jobscanningmodule.domain.JobPosting;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JobPostingService {

	private final JobPostingRepository jobPostingRepository;

	@Transactional
	public String save(JobPosting jobPosting) {
		jobPostingRepository.save(jobPosting);
		return jobPosting.getId();
	}

	public List<JobPosting> findJobs() {
		return jobPostingRepository.findAll();
	}

	public JobPosting findOne(String id) {
		return jobPostingRepository.findOne(id);
	}
}
