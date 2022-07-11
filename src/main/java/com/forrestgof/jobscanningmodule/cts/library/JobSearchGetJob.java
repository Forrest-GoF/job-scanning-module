package com.forrestgof.jobscanningmodule.cts.library;

import com.google.cloud.talent.v4.GetJobRequest;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.JobName;
import com.google.cloud.talent.v4.JobServiceClient;
import java.io.IOException;

public class JobSearchGetJob {

    public static void getJob() throws IOException {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "your-project-id";
        String tenantId = "your-tenant-id";
        String jobId = "your-job-id";
        getJob(projectId, tenantId, jobId);
    }

    // Get Job.
    public static void getJob(String projectId, String tenantId, String jobId) throws IOException {
        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
            JobName name = JobName.of(projectId, tenantId, jobId);

            GetJobRequest request = GetJobRequest.newBuilder().setName(name.toString()).build();

            Job response = jobServiceClient.getJob(request);
            System.out.format("Job name: %s%n", response.getName());
            System.out.format("Requisition ID: %s%n", response.getRequisitionId());
            System.out.format("Title: %s%n", response.getTitle());
            System.out.format("Description: %s%n", response.getDescription());
            System.out.format("Posting language: %s%n", response.getLanguageCode());
            for (String address : response.getAddressesList()) {
                System.out.format("Address: %s%n", address);
            }
            for (String email : response.getApplicationInfo().getEmailsList()) {
                System.out.format("Email: %s%n", email);
            }
            for (String websiteUri : response.getApplicationInfo().getUrisList()) {
                System.out.format("Website: %s%n", websiteUri);
            }
        }
    }
}