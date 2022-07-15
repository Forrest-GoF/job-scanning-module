package com.forrestgof.jobscanningmodule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	@Column(name = "location_name")
	private String name;

	public static Location from(String name) {
		Location location = new Location();
		location.name = name;

		return location;
	}
}
