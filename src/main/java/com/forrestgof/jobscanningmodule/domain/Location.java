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
public class Location {

	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private Long id;

	@Column(name = "location_name", unique = true)
	private String name;

	@OneToMany(mappedBy = "location")
	private List<JobPosting> jobPostings = new ArrayList<>();

	public static Location from(String name) {
		Location location = new Location();
		location.name = name;

		return location;
	}
}
