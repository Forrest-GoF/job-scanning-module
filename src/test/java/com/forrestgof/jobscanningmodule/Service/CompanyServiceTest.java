package com.forrestgof.jobscanningmodule.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.Repository.CompanyRepository;
import com.forrestgof.jobscanningmodule.domain.Company;

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
		Assertions.assertThat(company).isEqualTo(companyRepository.findOne(id));
	}
}
