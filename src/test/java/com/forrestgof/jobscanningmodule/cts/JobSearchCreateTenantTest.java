package com.forrestgof.jobscanningmodule.cts;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.forrestgof.jobscanningmodule.cts.library.JobSearchCreateTenant;

class JobSearchCreateTenantTest {

	@Test
	void createTenant() throws IOException {
		String projectId = "job-scanner-355820";
		String externalId = "Forrest-GoF";

		JobSearchCreateTenant.createTenant(projectId, externalId);
	}
}
