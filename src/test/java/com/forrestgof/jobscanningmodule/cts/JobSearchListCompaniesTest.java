package com.forrestgof.jobscanningmodule.cts;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.forrestgof.jobscanningmodule.cts.library.JobSearchListCompanies;

class JobSearchListCompaniesTest {

	@Test
	void listCompanies() throws IOException {
		String projectId = "job-scanner-355820";
		String tenantId = "1fd6aa61-e300-0000-0000-00c786556bf8";

		JobSearchListCompanies.listCompanies(projectId, tenantId);
	}

}
