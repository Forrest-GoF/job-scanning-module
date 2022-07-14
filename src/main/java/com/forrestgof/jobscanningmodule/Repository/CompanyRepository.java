package com.forrestgof.jobscanningmodule.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.forrestgof.jobscanningmodule.domain.Company;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {

	private final EntityManager em;

	public void save(Company company) {
		em.persist(company);
	}

	public Company findOne(Long id) {
		return em.find(Company.class, id);
	}

	public List<Company> findAll() {
		return em.createQuery("select c from Company c", Company.class)
			.getResultList();
	}
}
