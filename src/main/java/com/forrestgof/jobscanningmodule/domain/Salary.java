package com.forrestgof.jobscanningmodule.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Salary {

	@Column(name = "salary_from")
	private Integer from;

	@Column(name = "salary_to")
	private Integer to;

	@Column(name = "salary_currency")
	private Character currency;

	@Column(name = "salary_periodicity")
	private String periodicity;

	@Builder
	private Salary(Integer from, Integer to, Character currency, String periodicity) {
		this.from = from;
		this.to = to;
		this.currency = currency;
		this.periodicity = periodicity;
	}
}
