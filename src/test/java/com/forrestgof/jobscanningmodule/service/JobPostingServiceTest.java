package com.forrestgof.jobscanningmodule.service;

import java.time.OffsetDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.forrestgof.jobscanningmodule.domain.JobPosting;
import com.forrestgof.jobscanningmodule.domain.JobType;
import com.forrestgof.jobscanningmodule.repository.JobPostingRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class JobPostingServiceTest {

	@Autowired
	JobPostingService jobPostingService;
	@Autowired
	JobPostingRepository jobPostingRepository;

	@Test
	public void 공고저장() throws Exception {
		//given
		JobPosting jobPosting = JobPosting.builder()
			.key("12345")
			.title("네이버 갈사람~")
			.platform("잡코리아")
			.postedAt(OffsetDateTime.now())
			.jobType(JobType.FULLTIME)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.build();

		//when
		Long jobPostingId = jobPostingService.save(jobPosting);

		//then
		Assertions.assertThat(jobPosting).isEqualTo(jobPostingRepository.findById(jobPostingId).get());
	}

	@Test
	public void 키중복확인() throws Exception {
		//given
		JobPosting jobPosting = JobPosting.builder()
			.key("123456")
			.title("네이버 갈사람~")
			.platform("잡코리아")
			.postedAt(OffsetDateTime.now())
			.jobType(JobType.FULLTIME)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.build();

		//when
		jobPostingService.save(jobPosting);
		String key = jobPosting.getKey();

		//then
		Assertions.assertThat(jobPostingService.existsByKey(key)).isTrue();
	}

	@Test
	public void 키로조회() throws Exception {
		//given
		JobPosting jobPosting = JobPosting.builder()
			.key("1234567")
			.title("네이버 갈사람~")
			.platform("잡코리아")
			.postedAt(OffsetDateTime.now())
			.jobType(JobType.FULLTIME)
			.applyingUrl("www.naver.com")
			.description("테스트 입니다.")
			.build();

		//when
		Long id = jobPostingService.save(jobPosting);
		String key = jobPosting.getKey();

		//then
		Assertions.assertThat(jobPostingService.findByKey(key)).isEqualTo(jobPostingService.findOne(id));
	}
}
