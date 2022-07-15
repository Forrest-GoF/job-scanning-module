package com.forrestgof.jobscanningmodule.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.Repository.SalaryRepository;
import com.forrestgof.jobscanningmodule.domain.Salary;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class SalaryServiceTest {

	@Autowired
	SalaryRepository salaryRepository;
	@Autowired
	SalaryService salaryService;

	@Test
	public void 임금저장() throws Exception {
		//given
		Salary salary = Salary.builder()
			.to(1000000)
			.from(3000000)
			.currency('₩')
			.periodicity("월")
			.build();

		//when
		Long id = salaryService.save(salary);

		//then
		Assertions.assertThat(salary).isEqualTo(salaryRepository.findOne(id));
	}
}
