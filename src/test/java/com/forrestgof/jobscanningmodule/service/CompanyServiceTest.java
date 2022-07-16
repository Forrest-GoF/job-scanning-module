package com.forrestgof.jobscanningmodule.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.domain.Company;
import com.forrestgof.jobscanningmodule.repository.CompanyRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CompanyServiceTest {

	@Autowired
	CompanyService companyService;
	@Autowired
	CompanyRepository companyRepository;

	@Test
	public void 회사저장() throws Exception {
		//given
		Company company = Company.of("Naver", "www.naver.com");

		//when
		Long id = companyService.save(company);

		//then
		org.assertj.core.api.Assertions.assertThat(company).isEqualTo(companyRepository.findById(id).get());
	}
}
