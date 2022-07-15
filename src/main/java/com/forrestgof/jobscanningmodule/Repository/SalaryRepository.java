package com.forrestgof.jobscanningmodule.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.forrestgof.jobscanningmodule.domain.Salary;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SalaryRepository {

	private final EntityManager em;

	public void save(Salary salary) {
		em.persist(salary);
	}

	public Salary findOne(Long id) {
		return em.find(Salary.class, id);
	}

	public List<Salary> findAll() {
		return em.createQuery("select s from Salary s", Salary.class)
			.getResultList();
	}
}
