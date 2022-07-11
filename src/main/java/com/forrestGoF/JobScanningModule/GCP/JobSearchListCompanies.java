package com.forrestGoF.JobScanningModule.GCP;

import com.google.cloud.talent.v4.Company;
import com.google.cloud.talent.v4.CompanyServiceClient;
import com.google.cloud.talent.v4.ListCompaniesRequest;
import com.google.cloud.talent.v4.TenantName;
import java.io.IOException;

public class JobSearchListCompanies {

    public static void listCompanies() throws IOException {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "your-project-id";
        String tenantId = "your-tenant-id";
        listCompanies(projectId, tenantId);
    }

    // List Companies.
    public static void listCompanies(String projectId, String tenantId) throws IOException {
        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
            TenantName parent = TenantName.of(projectId, tenantId);

            ListCompaniesRequest request =
                    ListCompaniesRequest.newBuilder().setParent(parent.toString()).build();

            for (Company responseItem : companyServiceClient.listCompanies(request).iterateAll()) {
                System.out.format("Company Name: %s%n", responseItem.getName());
                System.out.format("Display Name: %s%n", responseItem.getDisplayName());
                System.out.format("External ID: %s%n", responseItem.getExternalId());
            }
        }
    }
}