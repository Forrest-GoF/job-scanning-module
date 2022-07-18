package com.forrestgof.jobscanningmodule.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.forrestgof.jobscanningmodule.dto.JobDetail;
import com.forrestgof.jobscanningmodule.dto.JobPreview;
import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.forrestgof.jobscanningmodule.service.JobService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JopPostingApiController {

	private final JobService jobService;

	@GetMapping("/search")
	public Result searchPostingPreview(@RequestBody @Valid SearchFilter searchFilter) {
		List<JobPreview> data = jobService.previews(searchFilter);
		System.out.println(searchFilter.getGl());

		return new Result(data);
	}

	@GetMapping("/job")
	public Result getJobDetail(@RequestBody @Valid KeyRequest request) {
		String key = request.getKey();
		JobDetail jobDetail = jobService.detail(key);

		return new Result(jobDetail);
	}

	@Data
	static class KeyRequest {
		@NotEmpty
		private String key;
	}

	@Data
	@AllArgsConstructor
	static class Result<T> {
		private T data;
	}
}
