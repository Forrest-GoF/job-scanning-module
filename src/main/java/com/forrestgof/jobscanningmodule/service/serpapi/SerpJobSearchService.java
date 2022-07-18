package com.forrestgof.jobscanningmodule.service.serpapi;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.forrestgof.jobscanningmodule.dto.CompanyDto;
import com.forrestgof.jobscanningmodule.dto.JobDetail;
import com.forrestgof.jobscanningmodule.dto.JobPreview;
import com.forrestgof.jobscanningmodule.dto.LocationDto;
import com.forrestgof.jobscanningmodule.dto.SearchFilter;
import com.forrestgof.jobscanningmodule.service.JobSearchService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerpJobSearchService extends JobSearchService {

	private final JobSearchLibraryService jobSearchLibraryService;
	Map<String, tempJobPreview> memoryJobRepository = new HashMap<>();

	@Override
	public List<JobPreview> searchPreview(SearchFilter searchFilter) {
		JsonObject searchResult = jobSearchLibraryService.search(searchFilter);

		List<JobPreview> jobPreviews = new ArrayList<>();
		JsonElement jobs_results = searchResult.get("jobs_results");
		JsonArray asJsonArray = jobs_results.getAsJsonArray();

		int key = 20;
		for (JsonElement jobElement : asJsonArray) {
			JsonObject job = jobElement.getAsJsonObject();

			String title = getValue(job, "title");
			String company_name = getValue(job, "company_name");
			String location = getValue(job, "location");
			String via = getValue(job, "via");
			String description = getValue(job, "description");
			String thumbnail = getValue(job, "thumbnail");
			JsonArray extensions = job.get("extensions").getAsJsonArray();
			OffsetDateTime posted_at = null;
			String schedule_type = "FULLTIME";
			String job_id = String.valueOf(key++);

			//TODO: posted_at 변환
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

			try {
				posted_at = OffsetDateTime.parse(extensions.get(0).toString(), formatter);
			} catch (Exception e) {
			}

			//TODO: schedule_type 한국어 Enum 처리
			try {
				//schedule_type = extensions.get(1).toString();
			} catch (Exception e) {
			}

			JobPreview jobPreview = new JobPreview();
			jobPreview.setTitle(title);
			jobPreview.setCompany(new CompanyDto(company_name, thumbnail));
			jobPreview.setLocation(new LocationDto(location));
			jobPreview.setPlatform(via);
			jobPreview.setPostedAt(posted_at);
			jobPreview.setType(schedule_type);
			jobPreview.setKey(job_id);

			memoryJobRepository.put(job_id, new tempJobPreview(jobPreview, description));
			jobPreviews.add(jobPreview);
		}

		return jobPreviews;
	}

	String getValue(JsonObject json, String key) {
		if (json.has(key)) {
			String s = json.get(key).toString();
			if (s.length() > 250) {
				return s.substring(0, 250);
			}
			return s;
		}
		return "";
	}

	@Data
	@AllArgsConstructor
	static class tempJobPreview {
		JobPreview jobPreview;
		String description;
	}

	@Override
	public JobDetail searchDetail(String key) {
		tempJobPreview tempJobPreview = memoryJobRepository.get(key);
		JobPreview jobPreview = tempJobPreview.getJobPreview();
		String description = tempJobPreview.getDescription();

		JobDetail jobDetail = new JobDetail();
		jobDetail.setKey(jobPreview.getKey());
		jobDetail.setTitle(jobPreview.getTitle());
		jobDetail.setCompany(jobPreview.getCompany());
		jobDetail.setLocation(jobPreview.getLocation());
		jobDetail.setPlatform(jobPreview.getPlatform());
		jobDetail.setPostedAt(jobPreview.getPostedAt());
		jobDetail.setSalary(jobPreview.getSalary());
		jobDetail.setType(jobPreview.getType());
		jobDetail.setDescription(description);
		return jobDetail;
	}
}
