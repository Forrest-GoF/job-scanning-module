package com.forrestgof.jobscanningmodule.Service;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.Repository.JobPostingRepository;
import com.forrestgof.jobscanningmodule.domain.Company;
import com.forrestgof.jobscanningmodule.domain.JobPosting;
import com.forrestgof.jobscanningmodule.domain.JobType;
import com.forrestgof.jobscanningmodule.domain.Location;
import com.forrestgof.jobscanningmodule.domain.Salary;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class IntegratedJobPostingTest {

	@Autowired
	CompanyService companyService;
	@Autowired
	LocationService locationService;
	@Autowired
	SalaryService salaryService;
	@Autowired
	JobPostingService jobPostingService;
	@Autowired
	JobPostingRepository jobPostingRepository;

	@Test
	public void 통합_공고저장() throws Exception {
		//given
		Company company = Company.of("Naver", "www.naver.com");
		Location location = Location.from("경기도 용인시");
		Salary salary = Salary.builder()
			.to(1000000)
			.from(3000000)
			.currency('₩')
			.periodicity("월")
			.build();

		JobPosting jobPosting = JobPosting.builder()
			.id("123")
			.company(company)
			.location(location)
			.title("네이버 갈사람~")
			.platform("잡코리아")
			.postedAt(LocalDateTime.now())
			.jobType(JobType.FULLTIME)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.salary(salary)
			.build();

		//when
		companyService.save(company);
		locationService.save(location);
		String jobPostingId = jobPostingService.save(jobPosting);

		//then
		Assertions.assertThat(jobPosting).isEqualTo(jobPostingRepository.findOne(jobPostingId));
	}
}
