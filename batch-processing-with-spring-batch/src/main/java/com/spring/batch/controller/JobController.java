package com.spring.batch.controller;

import com.spring.batch.config.SampleBatchJobConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class JobController {
    private final JobLauncher jobLauncher;
    private final SampleBatchJobConfiguration sampleBatchJobConfiguration;
    private final JobOperator jobOperator;
    private final JobInstance jobInstance;

    @GetMapping("/run/sample/job")
    public String runSampleJob(){
        try {
            JobParameters parameters = new JobParametersBuilder()
                    .addString("JobId", String.valueOf(System.currentTimeMillis()))
                            .toJobParameters();
            JobExecution execution = jobLauncher.run(sampleBatchJobConfiguration.sampleJob2(), parameters);

            return execution.getJobId().toString() + " " + execution.getExitStatus();
        } catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException | JobRestartException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/run/person/job")
    public void runPersonJob(){
        JobParameters parameters = new JobParametersBuilder()
                .addString("JobId", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
    }

    @GetMapping("/stop/job")
    public String stopAllRunningJobs(){
        Set<String> allJobsInContext = jobOperator.getJobNames();
        Long id = jobInstance.getInstanceId();
        String instanceName = jobInstance.getJobName();

        int index = 1;
        for(String job : allJobsInContext){
            System.out.println(String.valueOf(index) + "-->" + job );
            index+=1;
        }
        return "All Jobs Stopped";
    }
}
