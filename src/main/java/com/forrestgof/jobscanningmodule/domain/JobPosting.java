package com.forrestgof.jobscanningmodule.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class JobPosting {

	@Id
	@Column(name = "job_id")
	private String id;

	@Column(name = "job_title")
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;

	@Column(name = "platform_name")
	private String platform;

	@Column(name = "job_posted_at")
	private LocalDateTime postedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "job_type")
	private JobType jobType;

	@Column(name = "applying_url")
	private String applyingUrl;

	@Column(name = "job_description")
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salary_id")
	private Salary salary;

}
