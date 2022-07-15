package com.forrestgof.jobscanningmodule.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.Repository.CompanyRepository;
import com.forrestgof.jobscanningmodule.domain.Company;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;

	@Transactional
	public Long save(Company company) {
		companyRepository.save(company);
		return company.getId();
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company findOne(Long id) {
		return companyRepository.findOne(id);
	}
}
