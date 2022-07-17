package com.forrestgof.jobscanningmodule.domain;

import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Long id;

	//TODO: Unique 특성 추가
	@Column(name = "external_key")
	private String key;

	@Column(name = "job_title")
	private String title;

	//TODO: cascade 조건 제거 고려
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;

	//TODO: cascade 조건 제거 고려
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;

	@Column(name = "platform_name")
	private String platform;

	@Column(name = "job_posted_at")
	private OffsetDateTime postedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "job_type")
	private JobType jobType;

	@Column(name = "applying_url")
	private String applyingUrl;

	@Column(name = "job_description")
	private String description;

	@Embedded
	private Salary salary;

	@Builder
	public JobPosting(String key, String title, Company company, Location location, String platform,
		OffsetDateTime postedAt, JobType jobType, String applyingUrl, String description,
		Salary salary) {
		this.key = key;
		this.title = title;
		this.company = company;
		this.location = location;
		this.platform = platform;
		this.postedAt = postedAt;
		this.jobType = jobType;
		this.applyingUrl = applyingUrl;
		this.description = description;
		this.salary = salary;
	}
}
