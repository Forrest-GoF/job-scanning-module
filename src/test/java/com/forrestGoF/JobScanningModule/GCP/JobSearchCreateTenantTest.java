package com.forrestGoF.JobScanningModule.GCP;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class JobSearchCreateTenantTest {

    @Test
    void createTenant() throws IOException {
        String projectId = "job-scanner-355820";
        String externalId = "Forrest-GoF";

        JobSearchCreateTenant.createTenant(projectId, externalId);
    }
}
