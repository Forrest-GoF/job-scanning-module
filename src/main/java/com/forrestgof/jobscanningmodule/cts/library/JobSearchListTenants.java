package com.forrestgof.jobscanningmodule.cts.library;

import java.io.IOException;

import com.google.cloud.talent.v4.ListTenantsRequest;
import com.google.cloud.talent.v4.ProjectName;
import com.google.cloud.talent.v4.Tenant;
import com.google.cloud.talent.v4.TenantServiceClient;

public class JobSearchListTenants {

	public static void listTenants() throws IOException {
		// TODO(developer): Replace these variables before running the sample.
		String projectId = "your-project-id";
		listTenants(projectId);
	}

	// List Tenants.
	public static void listTenants(String projectId) throws IOException {
		// Initialize client that will be used to send requests. This client only needs to be created
		// once, and can be reused for multiple requests. After completing all of your requests, call
		// the "close" method on the client to safely clean up any remaining background resources.
		try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
			ProjectName parent = ProjectName.of(projectId);

			ListTenantsRequest request =
				ListTenantsRequest.newBuilder().setParent(parent.toString()).build();

			for (Tenant responseItem : tenantServiceClient.listTenants(request).iterateAll()) {
				System.out.format("Tenant Name: %s%n", responseItem.getName());
				System.out.format("External ID: %s%n", responseItem.getExternalId());
			}
		}
	}
}
