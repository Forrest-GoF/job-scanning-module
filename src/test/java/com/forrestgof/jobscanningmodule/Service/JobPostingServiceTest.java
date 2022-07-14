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
class JobPostingServiceTest {

	@Autowired
	JobPostingService jobPostingService;
	@Autowired
	JobPostingRepository jobPostingRepository;

	@Test
	public void 미완성_공고저장() throws Exception {
		//given
		JobPosting jobPosting = JobPosting.builder()
			.id("12345")
			.title("네이버 갈사람~")
			.platform("잡코리아")
			.postedAt(LocalDateTime.now())
			.jobType(JobType.FULLTIME)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.build();

		//when
		String jobPostingId = jobPostingService.save(jobPosting);

		//then
		Assertions.assertThat(jobPosting).isEqualTo(jobPostingRepository.findOne(jobPostingId));
	}

	@Test
	public void 통합_공고저장() throws Exception {
		//given
		JobPosting jobPosting = JobPosting.builder()
			.id("12345")
			.company(Company.of("Naver", "www.naver.com"))
			.location(Location.from("경기도 용인시"))
			.title("네이버 갈사람~")
			.platform("잡코리아")
			.postedAt(LocalDateTime.now())
			.jobType(JobType.FULLTIME)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.salary(Salary.builder()
				.to(1000000)
				.from(3000000)
				.currency('₩')
				.periodicity("월")
				.build())
			.build();

		//when
		String jobPostingId = jobPostingService.save(jobPosting);

		//then
		Assertions.assertThat(jobPosting).isEqualTo(jobPostingRepository.findOne(jobPostingId));
	}
}
