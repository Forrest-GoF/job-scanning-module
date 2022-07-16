package com.forrestgof.jobscanningmodule.dto;

import java.time.LocalDateTime;

import com.forrestgof.jobscanningmodule.domain.Salary;

import lombok.Data;

@Data
public class JobPreview {
	private String key;
	private String title;
	private CompanyDto company;
	private LocationDto location;
	private String platform;
	private LocalDateTime postedAt;
	private Salary salary;
	private String type;
}
