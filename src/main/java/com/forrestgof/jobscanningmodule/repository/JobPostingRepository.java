package com.forrestgof.jobscanningmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forrestgof.jobscanningmodule.domain.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

	JobPosting findByKey(String key);

	boolean existsByKey(String key);
}
