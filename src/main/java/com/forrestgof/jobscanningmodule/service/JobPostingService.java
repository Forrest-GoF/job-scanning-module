package com.forrestgof.jobscanningmodule.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.domain.JobPosting;
import com.forrestgof.jobscanningmodule.repository.JobPostingRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JobPostingService {

	private final JobPostingRepository jobPostingRepository;

	@Transactional
	public Long save(JobPosting jobPosting) {
		jobPostingRepository.save(jobPosting);
		return jobPosting.getId();
	}

	public List<JobPosting> findJobs() {
		return jobPostingRepository.findAll();
	}

	public JobPosting findOne(Long id) {
		return jobPostingRepository.findById(id).get();
	}

	public JobPosting findByKey(String key) {
		return jobPostingRepository.findByKey(key);
	}

	public boolean existsByKey(String key) {
		return jobPostingRepository.existsByKey(key);
	}
}
