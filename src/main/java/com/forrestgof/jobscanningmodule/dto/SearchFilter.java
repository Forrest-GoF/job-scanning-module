package com.forrestgof.jobscanningmodule.dto;

import lombok.Data;

@Data
public class SearchFilter {
	String q = "";
	String location = "South Korea";
	String uule = "";
	String googleDomain = "google.co.kr";
	String gl = "kr";
	String hl = "ko";
	String start = "";
	String chips = "";
	String irad = "";
}
