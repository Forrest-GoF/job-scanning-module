package com.forrestgof.jobscanningmodule.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.forrestgof.jobscanningmodule.domain.JobPosting;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JobPostingRepository {

	private final EntityManager em;

	public void save(JobPosting job) {
		em.persist(job);
	}

	public JobPosting findOne(String id) {
		return em.find(JobPosting.class, id);
	}

	public List<JobPosting> findAll() {

		return em.createQuery("select j from JobPosting j", JobPosting.class)
			.getResultList();
	}
}
