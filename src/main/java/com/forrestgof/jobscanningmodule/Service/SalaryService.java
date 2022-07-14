package com.forrestgof.jobscanningmodule.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.Repository.SalaryRepository;
import com.forrestgof.jobscanningmodule.domain.Salary;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SalaryService {

	private final SalaryRepository salaryRepository;

	@Transactional
	public Long save(Salary salary) {
		salaryRepository.save(salary);
		return salary.getId();
	}

	public Salary findOne(Long id) {
		return salaryRepository.findOne(id);
	}

	public List<Salary> findAll() {
		return salaryRepository.findAll();
	}
}
