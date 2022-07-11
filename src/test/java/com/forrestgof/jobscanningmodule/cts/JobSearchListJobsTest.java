package com.forrestgof.jobscanningmodule.cts;

import com.forrestgof.jobscanningmodule.cts.library.JobSearchListJobs;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JobSearchListJobsTest {

    @Test
    void listJobs() throws IOException {
        String projectId = "job-scanner-355820";
        String tenantId = "1fd6aa61-e300-0000-0000-00c786556bf8";
        String query = "count(base_compensation, [bucket(12, 20)])";
        JobSearchListJobs.listJobs(projectId, tenantId, query);
    }
}
