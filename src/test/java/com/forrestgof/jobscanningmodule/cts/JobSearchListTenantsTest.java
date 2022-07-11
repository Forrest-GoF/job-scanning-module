package com.forrestgof.jobscanningmodule.cts;

import com.forrestgof.jobscanningmodule.cts.library.JobSearchListTenants;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JobSearchListTenantsTest {

    @Test
    void listTenants() throws IOException {
        String projectId = "job-scanner-355820";
        JobSearchListTenants.listTenants(projectId);
    }
}

//    Tenant Name: projects/job-scanner-355820/tenants/1fd6aa61-e300-0000-0000-00c786556bf8
//        External ID: default
