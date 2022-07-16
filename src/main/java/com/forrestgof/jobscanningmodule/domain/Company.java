package com.forrestgof.jobscanningmodule.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {

	@Id
	@GeneratedValue
	@Column(name = "company_id")
	private Long id;

	@Column(name = "company_name", unique = true)
	private String name;

	@Column(name = "company_thumbnail")
	private String thumbnail;

	@OneToMany(mappedBy = "company")
	private List<JobPosting> jobPostings = new ArrayList<>();

	public static Company of(String name, String thumbnail) {
		Company company = new Company();
		company.name = name;
		company.thumbnail = thumbnail;

		return company;
	}
}
