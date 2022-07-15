package com.forrestgof.jobscanningmodule.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class JobPreviewDto {
	private String id;
	private String title;
	private String company;
	private String thumbnail;
	private String location;
	private String platform;
	private LocalDateTime postedAt;
	private String salary;
	private String type;
}
