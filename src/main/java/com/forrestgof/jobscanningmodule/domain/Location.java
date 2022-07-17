package com.forrestgof.jobscanningmodule.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

	//TODO: Unique 특성 추가
	@Column(name = "location_name")
	private String name;

	//TODO: cascade 조건 제거 고려
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private List<JobPosting> jobPostings = new ArrayList<>();

	public static Location from(String name) {
		Location location = new Location();
		location.name = name;

		return location;
	}
}
