package com.forrestgof.jobscanningmodule.service;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.domain.Company;
import com.forrestgof.jobscanningmodule.domain.JobPosting;
import com.forrestgof.jobscanningmodule.domain.JobType;
import com.forrestgof.jobscanningmodule.domain.Location;
import com.forrestgof.jobscanningmodule.domain.Salary;
import com.forrestgof.jobscanningmodule.repository.JobPostingRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class IntegratedJobPostingTest {

	@Autowired
	JobPostingService jobPostingService;
	@Autowired
	CompanyService companyService;
	@Autowired
	LocationService locationService;
	@Autowired
	JobPostingRepository jobPostingRepository;

	@Test
	public void 통합공고저장() throws Exception {
		//given
		Company company = Company.of("Naver", "www.naver.com");
		Location location = Location.from("경기도 용인시");
		Salary salary = Salary.builder()
			.from(10000)
			.to(20000)
			.currency('$')
			.periodicity("월")
			.build();
		JobPosting jobPosting = JobPosting.builder()
			.key("12345")
			.title("네이버 갈사람~")
			.company(company)
			.location(location)
			.platform("잡코리아")
			.postedAt(LocalDateTime.now())
			.jobType(JobType.FULLTIME)
			.salary(salary)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.build();

		//when
		Long jobPostingId = jobPostingService.save(jobPosting);

		//then
		Assertions.assertThat(jobPosting).isEqualTo(jobPostingRepository.findById(jobPostingId).get());
	}

}
